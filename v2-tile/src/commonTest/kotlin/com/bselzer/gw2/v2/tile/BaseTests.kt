package com.bselzer.gw2.v2.tile

import com.bselzer.gw2.v2.client.client.Gw2Client
import com.bselzer.gw2.v2.tile.client.TileClient
import com.bselzer.gw2.v2.tile.client.TileClientConfiguration
import io.ktor.client.*
import kotlinx.coroutines.runBlocking

abstract class BaseTests {
    private val gw2 = Gw2Client()
    private val tile = createTileClient()

    private fun createTileClient(): TileClient = TileClient(createHttpClient(), createConfiguration())
    open fun createHttpClient(): HttpClient = HttpClient()
    open fun createConfiguration(): TileClientConfiguration = TileClientConfiguration()

    /**
     * Closes the GW2 client after getting the request response.
     * @return the response of the request performed by the [block]
     */
    protected fun <T> use(block: suspend TileClient.() -> T): T {
        return runBlocking { tile.use { block(tile) } }
    }

    /**
     * Gets the request response.
     * @return the response of the request performed by the [block]
     */
    protected fun <T> get(block: suspend TileClient.() -> T): T {
        return runBlocking { tile.run { block(tile) } }
    }

    protected fun wvwContinent() = getGw2 { continent.continent(2) }
    protected fun wvwFloor() = getGw2 { continent.floor(2, 3) }

    /**
     * Closes the GW2 client after getting the request response.
     * @return the response of the request performed by the [block]
     */
    protected fun <T> useGw2(block: suspend Gw2Client.() -> T): T {
        return runBlocking { gw2.use { block(gw2) } }
    }

    /**
     * Gets the request response.
     * @return the response of the request performed by the [block]
     */
    protected fun <T> getGw2(block: suspend Gw2Client.() -> T): T {
        return runBlocking { gw2.run { block(gw2) } }
    }
}