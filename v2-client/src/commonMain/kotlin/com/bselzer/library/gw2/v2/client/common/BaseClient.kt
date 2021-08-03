package com.bselzer.library.gw2.v2.client.common

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Endpoints
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
    private fun HttpRequestBuilder.idsParameter(ids: Collection<*>) = parameter("ids", ids.asIdsParameter())

    /**
     * Chunks the ids into requests small enough for the API to accept, if there are more than [Endpoints.MAXIMUM_PAGE_SIZE] ids.
     *
     * @return the collection of ids represented by the ids
     */
    protected suspend fun <T> chunked(ids: Collection<*>, basePath: String, block: HttpRequestBuilder.() -> Unit = {}): List<T>
    {
        val responses = mutableListOf<T>()
        for (chunk in ids.chunked(configuration.pageSize))
        {
            responses.addAll(httpClient.get(path = basePath) {
                idsParameter(chunk)
                apply(block)
            })
        }
        return responses
    }
}