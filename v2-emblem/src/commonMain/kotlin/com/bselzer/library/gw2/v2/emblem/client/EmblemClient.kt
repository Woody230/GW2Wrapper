package com.bselzer.library.gw2.v2.emblem.client

import com.bselzer.library.gw2.v2.emblem.constant.Parameters
import com.bselzer.library.gw2.v2.emblem.extension.encodeOptions
import com.bselzer.library.gw2.v2.emblem.extension.options
import com.bselzer.library.gw2.v2.emblem.request.EmblemRequest
import com.bselzer.library.gw2.v2.emblem.request.EmblemRequestOptions
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.utils.io.core.*
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

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
     * @return the deferred emblem
     */
    suspend fun emblemAsync(request: EmblemRequest): Deferred<ByteArray> = coroutineScope {
        // Use async for parallelism.
        async {
            return@async try {
                httpClient.get(request.constructBaseUrl()) {
                    options(request.options)
                }
            } catch (ex: Exception) {
                ByteArray(0)
            }
        }
    }

    /**
     * @param request the request to get the emblem content from
     * @return the emblem
     */
    suspend fun emblem(request: EmblemRequest) = emblemAsync(request).await()

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