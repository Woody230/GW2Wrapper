package com.bselzer.library.gw2.v2.client.client

import com.bselzer.library.gw2.v2.client.client.ExceptionRecoveryMode.DEFAULT
import com.bselzer.library.gw2.v2.client.client.ExceptionRecoveryMode.NONE
import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import io.ktor.client.*
import io.ktor.client.request.*

abstract class BaseClient(
    protected val httpClient: HttpClient,
    protected val configuration: Gw2ClientConfiguration
)
{
    protected companion object {
        // TODO Expect/actual is used because of publishing not working due to the reflection artifact. https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/
        val DEFAULT_RECOVERY = DefaultRecovery()
    }

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
    protected fun HttpRequestBuilder.idsParameter(ids: Collection<*>, parameterName: String = "ids") = parameter(parameterName, ids.asIdsParameter())

    /**
     * Adds the ids as "all".
     */
    protected fun HttpRequestBuilder.allIdsParameter(parameterName: String = "ids") = parameter(parameterName, "all")

    /**
     * Gets the object without recovery.
     *
     * @return the object
     */
    protected suspend inline fun <reified T> forceGetSingle(path: String, block: HttpRequestBuilder.() -> Unit = {}): T = httpClient.get(path = path) {
        apply(block)
    }

    /**
     * Gets the object with recovery.
     *
     * @return the object
     */
    protected suspend inline fun <reified T> getSingle(path: String, block: HttpRequestBuilder.() -> Unit = {}): T =
        tryOrRecover({ defaultSingle() }) { forceGetSingle(path, block) }

    /**
     * Gets the identifiable object with recovery.
     * @return the identifiable object
     */
    protected suspend inline fun <reified T : Identifiable<Id>, Id> getIdentifiableSingle(
        id: Id,
        path: String,
        default: () -> T = { defaultSingle(id) },
        block: HttpRequestBuilder.() -> Unit = {}
    ): T = tryOrRecover(default) { forceGetSingle(path, block) }

    /**
     * Gets the objects with recovery.
     *
     * @return the objects
     */
    protected suspend inline fun <reified T> getList(path: String, block: HttpRequestBuilder.() -> Unit = {}): List<T> = tryOrRecover(
        { emptyList() }
    ) {
        httpClient.get(path = path) {
            apply(block)
        }
    }

    /**
     * Chunks the ids into requests small enough for the API to accept, if there are more ids than the configuration page size.
     *
     * @return the collection of objects represented by the ids
     */
    protected suspend inline fun <reified T : Identifiable<Id>, Id> chunkedIds(ids: Collection<Id>, path: String, block: HttpRequestBuilder.() -> Unit = {}): List<T> =
        chunked(ids, path, "ids", block)

    /**
     * Chunks the ids into requests small enough for the API to accept, if there are more ids than the configuration page size.
     *
     * @return the collection of objects represented by the ids
     */
    protected suspend inline fun <reified T : Identifiable<Id>, Id> chunkedTabs(ids: Collection<Id>, path: String, block: HttpRequestBuilder.() -> Unit = {}): List<T> =
        chunked(ids, path, "tabs", block)

    /**
     * @return all the objects
     */
    protected suspend inline fun <reified T> allIds(path: String, block: HttpRequestBuilder.() -> Unit = {}): List<T> = all(path, "ids", block)

    /**
     * @return all the objects
     */
    protected suspend inline fun <reified T> allTabs(path: String, block: HttpRequestBuilder.() -> Unit = {}): List<T> = all(path, "tabs", block)

    /**
     * Chunks the ids into requests small enough for the API to accept, if there are more ids than the configuration page size.
     *
     * @return the collection of objects represented by the ids
     */
    protected suspend inline fun <reified T : Identifiable<Id>, Id> chunked(
        ids: Collection<Id>,
        path: String,
        idsParameterName: String,
        block: HttpRequestBuilder.() -> Unit = {}
    ): List<T> = tryOrRecover(
        { defaultAll(ids) }
    ) {
        val responses = mutableListOf<T>()
        for (chunk in ids.toHashSet().chunked(configuration.pageSize)) {
            responses.addAll(httpClient.get(path = path) {
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
        httpClient.get(path = path) {
            allIdsParameter(idParameterName)
            apply(block)
        }
    }

    /**
     * Gets the identifiable object with recovery.
     *
     * @return a single object
     */
    protected suspend inline fun <reified T : Identifiable<Id>, Id> getSingleById(id: Id, path: String, block: HttpRequestBuilder.() -> Unit = {}): T = tryOrRecover(
        default = { defaultSingle(id) }
    ) {
        httpClient.get(path = path) {
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
     * Creates a new default instance of a single object.
     */
    protected inline fun <reified T> defaultSingle(): T = DEFAULT_RECOVERY.defaultSingle()

    /**
     * Creates a new default instance of a single object with the id populated.
     */
    protected inline fun <reified T : Identifiable<Id>, Id> defaultSingle(id: Id): T = DEFAULT_RECOVERY.defaultSingle(id)

    /**
     * Creates a new default instance of multiple objects with the id populated.
     */
    protected inline fun <reified T : Identifiable<Id>, Id> defaultAll(ids: Collection<Id>): List<T> = ids.map { id -> defaultSingle(id) }
}