package com.bselzer.gw2.asset.cdn

import com.bselzer.gw2.asset.cdn.client.AssetCdnClient
import com.bselzer.gw2.asset.cdn.client.AssetCdnClientConfiguration
import io.ktor.client.*
import kotlinx.coroutines.runBlocking

abstract class BaseTests {
    private val assetCdn = createAssetCdnClient()

    private fun createAssetCdnClient(): AssetCdnClient = AssetCdnClient(createHttpClient(), createConfiguration())
    open fun createHttpClient(): HttpClient = HttpClient()
    open fun createConfiguration(): AssetCdnClientConfiguration = AssetCdnClientConfiguration()

    /**
     * Closes the client after getting the request response.
     * @return the response of the request performed by the [block]
     */
    protected fun <T> use(block: suspend AssetCdnClient.() -> T): T {
        return runBlocking { assetCdn.use { block(assetCdn) } }
    }

    /**
     * Gets the request response.
     * @return the response of the request performed by the [block]
     */
    protected fun <T> get(block: suspend AssetCdnClient.() -> T): T {
        return runBlocking { assetCdn.run { block(assetCdn) } }
    }
}