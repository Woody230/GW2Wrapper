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
     * Adds the ids as a comma separated string.
     */
    protected fun HttpRequestBuilder.idsParameter(ids: Collection<*>, parameterName: String = "ids") = parameter(parameterName, ids.asIdsParameter())

    /**
     * Adds the ids as "all".
     */
    protected fun HttpRequestBuilder.allIdsParameter(parameterName: String = "ids") = parameter(parameterName, "all")

    // TODO T inherit an id from an interface, and use its type instead of *
    /**
     * Chunks the ids into requests small enough for the API to accept, if there are more ids than the configuration page size.
     *
     * @return the collection of objects represented by the ids
     */
    protected suspend inline fun <reified T> chunkedIds(ids: Collection<*>, basePath: String, block: HttpRequestBuilder.() -> Unit = {}): List<T> =
        chunked(ids, basePath, "ids", block)

    /**
     * Chunks the ids into requests small enough for the API to accept, if there are more ids than the configuration page size.
     *
     * @return the collection of objects represented by the ids
     */
    protected suspend inline fun <reified T> chunkedTabs(ids: Collection<*>, basePath: String, block: HttpRequestBuilder.() -> Unit = {}): List<T> =
        chunked(ids, basePath, "tabs", block)

    /**
     * @return all the objects
     */
    protected suspend inline fun <reified T> allIds(basePath: String, block: HttpRequestBuilder.() -> Unit = {}): List<T> = all(basePath, "ids", block)

    /**
     * @return all the objects
     */
    protected suspend inline fun <reified T> allTabs(basePath: String, block: HttpRequestBuilder.() -> Unit = {}): List<T> = all(basePath, "tabs", block)

    /**
     * Chunks the ids into requests small enough for the API to accept, if there are more tids than the configuration page size.
     *
     * @return the collection of objects represented by the ids
     */
    protected suspend inline fun <reified T> chunked(ids: Collection<*>, basePath: String, idsParameterName: String, block: HttpRequestBuilder.() -> Unit = {}): List<T>
    {
        val responses = mutableListOf<T>()
        for (chunk in ids.chunked(configuration.pageSize))
        {
            responses.addAll(httpClient.get(path = basePath) {
                idsParameter(chunk, idsParameterName)
                apply(block)
            })
        }
        return responses
    }

    /**
     * @return all the objects
     */
    protected suspend inline fun <reified T> all(basePath: String, idParameterName: String, block: HttpRequestBuilder.() -> Unit = {}): List<T> =
        httpClient.get(path = basePath) {
            allIdsParameter(idParameterName)
            apply(block)
        }
}