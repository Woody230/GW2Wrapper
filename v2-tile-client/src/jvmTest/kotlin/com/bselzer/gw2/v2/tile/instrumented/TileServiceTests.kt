package com.bselzer.gw2.v2.tile.instrumented

import com.bselzer.gw2.v2.client.constant.Endpoints
import com.bselzer.gw2.v2.tile.BaseTests
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
        assertEquals(256.0, grid.tileSize.width)
        assertEquals(256.0, grid.tileSize.height)

        val tile = grid.tiles[0]
        assertEquals(0, tile.gridPosition.x)
        assertEquals(0, tile.gridPosition.y)
        assertTrue(tile.content.isNotEmpty())
    }

    // TODO more tests
}