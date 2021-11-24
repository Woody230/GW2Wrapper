package com.bselzer.library.gw2.v2.emblem

import com.bselzer.library.gw2.v2.emblem.client.EmblemClient
import com.bselzer.library.gw2.v2.emblem.client.EmblemClientConfiguration
import io.ktor.client.*
import kotlinx.coroutines.runBlocking

abstract class BaseTests {
    private val emblem = createEmblemClient()

    private fun createEmblemClient(): EmblemClient = EmblemClient(createHttpClient(), createConfiguration())
    open fun createHttpClient(): HttpClient = HttpClient()
    open fun createConfiguration(): EmblemClientConfiguration = EmblemClientConfiguration()

    /**
     * Closes the GW2 client after getting the request response.
     * @return the response of the request performed by the [block]
     */
    protected fun <T> use(block: suspend EmblemClient.() -> T): T {
        return runBlocking { emblem.use { block(emblem) } }
    }

    /**
     * Gets the request response.
     * @return the response of the request performed by the [block]
     */
    protected fun <T> get(block: suspend EmblemClient.() -> T): T {
        return runBlocking { emblem.run { block(emblem) } }
    }
}