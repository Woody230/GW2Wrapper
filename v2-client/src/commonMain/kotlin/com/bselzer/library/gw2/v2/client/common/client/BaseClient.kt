package com.bselzer.library.gw2.v2.client.common.client

import io.ktor.client.*
import io.ktor.client.request.*

abstract class BaseClient(
    protected val httpClient: HttpClient,
    protected val configuration: Gw2ClientConfiguration
)
{
    /**
     * @return the ids as a comma separated string or "-1" if there are no ids
     */
    private fun Collection<*>.asIdsParameter(): String = if (isEmpty())
    {
        // {"text": "all ids provided are invalid"} is returned when no ids are provided
        "-1"
    } else
    {
        joinToString(separator = ",")
    }

    /**
     * Adds the id.
     */
    protected fun HttpRequestBuilder.idParameter(id: Any) = parameter("id", id)

    /**
     * Adds the ids as a comma separated string.
     */
    protected fun HttpRequestBuilder.idsParameter(ids: Collection<*>, parameterName: String = "ids") = parameter(parameterName, ids.asIdsParameter())

    /**
     * Adds the ids as "all".
     */
    protected fun HttpRequestBuilder.allIdsParameter(parameterName: String = "ids") = parameter(parameterName, "all")

    /**
     * @return the object
     */
    protected suspend inline fun <reified T> get(path: String, block: HttpRequestBuilder.() -> Unit = {}): T = httpClient.get(path = path) {
        apply(block)
    }

    // TODO T inherit an id from an interface, and use its type instead of *
    /**
     * Chunks the ids into requests small enough for the API to accept, if there are more ids than the configuration page size.
     *
     * @return the collection of objects represented by the ids
     */
    protected suspend inline fun <reified T> chunkedIds(ids: Collection<*>, path: String, block: HttpRequestBuilder.() -> Unit = {}): List<T> =
        chunked(ids, path, "ids", block)

    /**
     * Chunks the ids into requests small enough for the API to accept, if there are more ids than the configuration page size.
     *
     * @return the collection of objects represented by the ids
     */
    protected suspend inline fun <reified T> chunkedTabs(ids: Collection<*>, path: String, block: HttpRequestBuilder.() -> Unit = {}): List<T> =
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
     * Chunks the ids into requests small enough for the API to accept, if there are more tids than the configuration page size.
     *
     * @return the collection of objects represented by the ids
     */
    protected suspend inline fun <reified T> chunked(ids: Collection<*>, path: String, idsParameterName: String, block: HttpRequestBuilder.() -> Unit = {}): List<T>
    {
        val responses = mutableListOf<T>()
        for (chunk in ids.chunked(configuration.pageSize))
        {
            responses.addAll(httpClient.get(path = path) {
                idsParameter(chunk, idsParameterName)
                apply(block)
            })
        }
        return responses
    }

    /**
     * @return all the objects
     */
    protected suspend inline fun <reified T> all(path: String, idParameterName: String, block: HttpRequestBuilder.() -> Unit = {}): List<T> =
        httpClient.get(path = path) {
            allIdsParameter(idParameterName)
            apply(block)
        }

    /**
     * @return a single object
     */
    protected suspend inline fun <reified T> single(id: Any, path: String, block: HttpRequestBuilder.() -> Unit = {}): T =
        httpClient.get(path = path) {
            idParameter(id)
            apply(block)
        }
}