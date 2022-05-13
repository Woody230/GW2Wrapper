package com.bselzer.gw2.asset.cdn.client

import com.bselzer.gw2.asset.cdn.model.Build
import com.bselzer.gw2.v2.model.build.BuildId
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.utils.io.core.*

/**
 * The client for retrieving assetcdn information.
 */
class AssetCdnClient(
    private var httpClient: HttpClient = HttpClient(),
    private var configuration: AssetCdnClientConfiguration = AssetCdnClientConfiguration()
) : Closeable {
    private companion object {
        const val CORE_ID = "101"
        const val CHINESE_ID = "111"
        const val LATEST = "latest"

        // These sites are not secured.
        const val BASE_CORE = "http://assetcdn.${CORE_ID}.arenanetworks.com"
        const val BASE_CHINESE = "http://assetcdn.${CHINESE_ID}.cgw2.com"
    }

    init {
        httpClient = httpClient.setup(configuration)
    }

    /**
     * @return a new [AssetCdnClient] with an updated [AssetCdnClientConfiguration]
     */
    fun config(block: AssetCdnClientConfiguration.() -> AssetCdnClientConfiguration) {
        httpClient = httpClient.setup(block(configuration))
    }

    /**
     * @return a new [AssetCdnClient] with an updated [HttpClientConfig]
     */
    fun httpClient(block: HttpClientConfig<*>.() -> Unit) {
        httpClient = httpClient.config(block).setup(configuration)
    }

    /**
     * @return a new http client with the configuration applied
     */
    private fun HttpClient.setup(configuration: AssetCdnClientConfiguration): HttpClient = config {
        defaultRequest {
            url(
                when (configuration.type) {
                    AssetCdnType.CORE -> BASE_CORE
                    AssetCdnType.CHINESE -> BASE_CHINESE
                }
            )
        }
    }

    /**
     * Gets the latest build information.
     *
     * If there is an issue trying to convert the response, values are defaulted to 0.
     */
    suspend fun latest(): Build {
        val content = try {
            httpClient.get("${LATEST}/${getId()}").body()
        } catch (ex: Exception) {
            ""
        }.split(' ')

        return Build(
            id = BuildId(content.extract(0)),
            executableFileId = content.extract(1),
            executableFileSize = content.extract(2),
            manifestFileId = content.extract(3),
            manifestFileSize = content.extract(4)
        )
    }

    /**
     * Extracts the value at [index] as an [Int], or 0 if unable to.
     */
    private fun List<String>.extract(index: Int) = getOrNull(index)?.toIntOrNull() ?: 0

    /**
     * @return the id associated with the type in the configuration
     */
    private fun getId(): String = when (configuration.type) {
        AssetCdnType.CORE -> CORE_ID
        AssetCdnType.CHINESE -> CHINESE_ID
    }

    /**
     * Close the HTTP client.
     */
    override fun close() {
        httpClient.close()
    }
}