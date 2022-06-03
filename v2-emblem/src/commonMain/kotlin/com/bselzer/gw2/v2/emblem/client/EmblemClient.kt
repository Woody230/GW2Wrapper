package com.bselzer.gw2.v2.emblem.client

import com.bselzer.gw2.v2.emblem.constant.Parameters
import com.bselzer.gw2.v2.emblem.extension.encodeOptions
import com.bselzer.gw2.v2.emblem.extension.options
import com.bselzer.gw2.v2.emblem.request.EmblemRequest
import com.bselzer.gw2.v2.emblem.request.EmblemRequestOptions
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.utils.io.core.*

/**
 * The emblem client using the service provided by Werdes.
 * @see <a href="https://emblem.werdes.net/">https://emblem.werdes.net/</a>
 */
open class EmblemClient(
    private val httpClient: HttpClient = HttpClient(),
    private val configuration: EmblemClientConfiguration = EmblemClientConfiguration()
) : Closeable {

    /**
     * @return a request for an emblem
     * @see <a href="https://emblem.werdes.net/">https://emblem.werdes.net/</a>
     */
    fun requestEmblem(guildId: String, size: Int = 128, vararg options: EmblemRequestOptions): EmblemRequest = EmblemRequest(
        guildId = guildId,
        size = size,
        options = options.toList()
    )

    /**
     * @return the url constructed by the [request]
     */
    fun emblemUrl(request: EmblemRequest): String {
        val base = request.constructBaseUrl()
        return if (request.options.isEmpty()) {
            base
        } else {
            "$base?${Parameters.OPTIONS}=${request.options.encodeOptions()}"
        }
    }

    /**
     * @param request the request to get the emblem content from
     * @return the byte content of the emblem
     */
    suspend fun emblem(request: EmblemRequest): ByteArray {
        val url = request.constructBaseUrl()
        return httpClient.get(url) { options(request.options) }.body()
    }

    /**
     * @param request the request to get the emblem content from
     * @return the byte content of the emblem, or null if unable to retrieve the emblem
     */
    suspend fun emblemOrNull(request: EmblemRequest): ByteArray? = try {
        httpClient.get(request.constructBaseUrl()) {
            options(request.options)
        }.body()
    } catch (ex: Exception) {
        null
    }

    /**
     * @param request the request to get the emblem content from
     * @return the byte content of the emblem, or an empty byte array if unable to retrieve the emblem
     */
    suspend fun emblemOrDefault(request: EmblemRequest): ByteArray = emblemOrNull(request) ?: ByteArray(0)

    /**
     * Gets the base url built upon the [EmblemClientConfiguration.baseUrl].
     */
    private fun EmblemRequest.constructBaseUrl(): String = "${configuration.baseUrl}/emblem/${guildId}/${size}"

    /**
     * Close the HTTP client.
     */
    override fun close() {
        httpClient.close()
    }
}