package com.bselzer.gw2.v2.tile.instrumented

import com.bselzer.gw2.v2.tile.BaseTests
import com.bselzer.gw2.v2.tile.constant.Endpoints
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class TileServiceTests : BaseTests() {
    /**
     * Verifies that content can be retrieved from the tile service.
     */
    @Test
    fun service_IsActive() {
        // Arrange
        val client = HttpClient()

        // Act
        val content = runBlocking { client.use { it.get("${Endpoints.BASE_URL}/2/3/0/0/0.jpg").body<ByteArray>() } }

        // Assert
        assertNotNull(content)
        assertTrue(content.isNotEmpty())
    }

    /**
     * Verifies that a zoom level 0 produces a single tile.
     */
    @Test
    fun grid_WithZoom0_GetsSingleTile() {
        // Arrange
        val continent = wvwContinent()
        val floor = wvwFloor()
        val zoom = 0

        // Act
        val grid = use { grid(continent, floor, zoom) }

        // Assert
        assertEquals(1, grid.tiles.size)
        assertEquals(256, grid.tileWidth)
        assertEquals(256, grid.tileHeight)

        val tile = grid.tiles[0]
        assertEquals(0, tile.gridX)
        assertEquals(0, tile.gridY)
        assertTrue(tile.content.isNotEmpty())
    }

    // TODO more tests
}