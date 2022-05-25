package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.instance.ExceptionRecoveryMode.DEFAULT
import com.bselzer.gw2.v2.client.instance.ExceptionRecoveryMode.NONE
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

sealed class BaseClient(
    protected val httpClient: HttpClient,
    protected val configuration: Gw2ClientConfiguration
) {
    /**
     * @return the ids as a comma separated string or "-1" if there are no ids
     */
    private fun Collection<*>.asIdsParameter(): String = if (isEmpty()) {
        // {"text": "all ids provided are invalid"} is returned when no ids are provided
        "-1"
    } else {
        joinToString(separator = ",")
    }

    /**
     * Adds the id.
     */
    protected fun HttpRequestBuilder.idParameter(id: Any?) = parameter("id", id)

    /**
     * Adds the ids as a comma separated string.
     */
    protected fun HttpRequestBuilder.idsParameter(ids: Collection<*>, parameterName: String = "ids") =
        parameter(parameterName, ids.asIdsParameter())

    /**
     * Adds the ids as "all".
     */
    protected fun HttpRequestBuilder.allIdsParameter(parameterName: String = "ids") = parameter(parameterName, "all")

    /**
     * Gets the object without recovery.
     *
     * @return the object
     */
    protected suspend inline fun <reified T> forceGetSingle(path: String, block: HttpRequestBuilder.() -> Unit = {}): T = request(path, block)

    /**
     * Gets the object with recovery.
     *
     * @return the object
     */
    protected suspend inline fun <reified T> getSingle(path: String, instance: () -> T, block: HttpRequestBuilder.() -> Unit = {}): T =
        tryOrRecover(instance) { forceGetSingle(path, block) }

    /**
     * Gets the identifiable object with recovery.
     * @return the identifiable object
     */
    protected suspend inline fun <reified T : Identifiable<Value>, Id : Identifier<Value>, Value> getIdentifiableSingle(
        id: Id,
        path: String,
        instance: (Id) -> T,
        block: HttpRequestBuilder.() -> Unit = {}
    ): T = tryOrRecover(default = { instance(id) }) { forceGetSingle(path, block) }

    /**
     * Gets the ids with recovery.
     */
    protected suspend inline fun <reified T : Identifier<Value>, Value> getIds(path: String, block: HttpRequestBuilder.() -> Unit = {}): List<T> = getList(path, block)

    /**
     * Gets the identifiable objects with recovery.
     */
    protected suspend inline fun <reified T : Identifiable<Value>, Value> getIdentifiableList(path: String, block: HttpRequestBuilder.() -> Unit = {}): List<T> =
        getList(path, block)

    /**
     * Gets the objects with recovery.
     *
     * @return the objects
     */
    protected suspend inline fun <reified T> getList(path: String, block: HttpRequestBuilder.() -> Unit = {}): List<T> = tryOrRecover(
        { emptyList() }
    ) {
        request(path, block)
    }

    /**
     * Chunks the ids into requests small enough for the API to accept, if there are more ids than the configuration page size.
     *
     * @return the collection of objects represented by the ids
     */
    protected suspend inline fun <reified T : Identifiable<Value>, Id : Identifier<Value>, Value> chunkedIds(
        ids: Collection<Id>,
        path: String,
        instance: (Id) -> T,
        block: HttpRequestBuilder.() -> Unit = {}
    ): List<T> = chunked(ids, path, "ids", instance, block)

    /**
     * Chunks the ids into requests small enough for the API to accept, if there are more ids than the configuration page size.
     *
     * @return the collection of objects represented by the ids
     */
    protected suspend inline fun <reified T : Identifiable<Value>, Id : Identifier<Value>, Value> chunkedTabs(
        ids: Collection<Id>,
        path: String,
        instance: (Id) -> T,
        block: HttpRequestBuilder.() -> Unit = {}
    ): List<T> = chunked(ids, path, "tabs", instance, block)

    /**
     * @return all the objects
     */
    protected suspend inline fun <reified T : Identifiable<Value>, Value> allIds(path: String, block: HttpRequestBuilder.() -> Unit = {}): List<T> =
        all(path, "ids", block)

    /**
     * @return all the objects
     */
    protected suspend inline fun <reified T : Identifiable<Value>, Value> allTabs(path: String, block: HttpRequestBuilder.() -> Unit = {}): List<T> =
        all(path, "tabs", block)

    /**
     * Chunks the ids into requests small enough for the API to accept, if there are more ids than the configuration page size.
     *
     * @return the collection of objects represented by the ids
     */
    protected suspend inline fun <reified T : Identifiable<Value>, Id : Identifier<Value>, Value> chunked(
        ids: Collection<Id>,
        path: String,
        idsParameterName: String,
        instance: (Id) -> T,
        block: HttpRequestBuilder.() -> Unit = {}
    ): List<T> = tryOrRecover(
        { ids.map { id -> instance(id) } }
    ) {
        val responses = mutableListOf<T>()
        for (chunk in ids.toHashSet().chunked(configuration.pageSize)) {
            responses.addAll(request(path) {
                idsParameter(chunk, idsParameterName)
                apply(block)
            })
        }
        responses
    }

    /**
     * @return all the objects
     */
    protected suspend inline fun <reified T> all(
        path: String,
        idParameterName: String,
        block: HttpRequestBuilder.() -> Unit = {}
    ): List<T> = tryOrRecover(
        // Don't know the associated ids so can't do proper defaulting.
        { emptyList() }
    ) {
        request(path) {
            allIdsParameter(idParameterName)
            apply(block)
        }
    }

    /**
     * Gets the identifiable object with recovery.
     *
     * @return a single object
     */
    protected suspend inline fun <reified T : Identifiable<Value>, Id : Identifier<Value>, Value> getSingleById(
        id: Id,
        path: String,
        instance: (Id) -> T,
        block: HttpRequestBuilder.() -> Unit = {}
    ): T = tryOrRecover(
        default = { instance(id) }
    ) {
        request(path) {
            idParameter(id)
            apply(block)
        }
    }

    /**
     * Attempts to call the [block]. If the [block] fails and the recovery mode is [DEFAULT], then the [default] is called.
     *
     * @return the result of the [block] or the recovery result
     */
    protected inline fun <reified T> tryOrRecover(default: () -> T, block: () -> T): T = try {
        block()
    } catch (exception: Exception) {
        when (configuration.exceptionRecoveryMode) {
            NONE -> throw exception
            DEFAULT -> default()
        }
    }

    /**
     * Makes the request for the object and verifies the status code.
     */
    protected suspend inline fun <reified T> request(path: String, block: HttpRequestBuilder.() -> Unit): T {
        val response = httpClient.get(path, block)

        // In the case where we are getting a 404, an empty default may be deserialized.
        // Consequently, throw and potentially let a tryOrRecover catch to properly construct a default.
        return if (!response.status.isSuccess()) {
            throw ResponseException(response, response.bodyAsText())
        } else {
            response.body()
        }
    }
}