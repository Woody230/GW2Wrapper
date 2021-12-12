package com.bselzer.gw2.v2.tile.model.response

import com.bselzer.gw2.v2.tile.model.request.TileGridRequest
import kotlinx.serialization.Serializable
import kotlin.math.pow

/**
 * The tiles within the grid.
 */
@Serializable
data class TileGrid(
    /**
     * The width of each individual tile.
     */
    val tileWidth: Int = 0,

    /**
     * The height of each individual tile.
     */
    val tileHeight: Int = 0,

    /**
     * The width of the texture.
     */
    val textureWidth: Int = 0,

    /**
     * The height of the texture.
     */
    val textureHeight: Int = 0,

    /**
     * The starting horizontal tile position.
     */
    val startX: Int = 0,

    /**
     * The ending horizontal tile position.
     */
    val endX: Int = 0,

    /**
     * The starting vertical tile position.
     */
    val startY: Int = 0,

    /**
     * The ending vertical tile position.
     */
    val endY: Int = 0,

    /**
     * The zoom level.
     */
    val zoom: Int = 0,

    /**
     * The subset of tiles with content.
     */
    val tiles: List<Tile> = emptyList(),
) {
    /**
     * All of the tiles within the boundary by rows.
     */
    val rows: List<List<Tile>> = createRows()

    /**
     * The number of columns within the grid.
     */
    val columnCount: Int = endX - startX + 1

    /**
     * The number of rows within the grid.
     */
    val rowCount: Int = endY - startY + 1

    /**
     * The width of the entire grid.
     */
    val width: Int = columnCount * tileWidth

    /**
     * The height of the entire grid.
     */
    val height: Int = rowCount * tileHeight

    /**
     * Creates a new instance using the data from the [request].
     */
    constructor(request: TileGridRequest, tiles: List<Tile> = emptyList()) : this(
        tileWidth = request.tileWidth,
        tileHeight = request.tileHeight,
        textureWidth = request.textureWidth,
        textureHeight = request.textureHeight,
        startX = request.startX,
        endX = request.endX,
        startY = request.startY,
        endY = request.endY,
        zoom = request.zoom,
        tiles = tiles
    )

    /**
     * @return the position scaled to the bounds of the grid within the [zoom] level
     */
    fun scale(x: Int, y: Int): Pair<Int, Int> {
        val zoom = textureScale(x, y)

        // Remove the excluded starting tiles.
        val scaledX = zoom.first - (startX * tileWidth)
        val scaledY = zoom.second - (startY * tileHeight)
        return Pair(scaledX, scaledY)
    }

    /**
     * @return the position scaled to the absolute coordinates within the [zoom] level
     */
    fun textureScale(x: Int, y: Int): Pair<Int, Int> {
        // Scale the coordinates to the current zoom level.
        val zoomWidth = 2.0.pow(zoom) * tileWidth
        val zoomHeight = 2.0.pow(zoom) * tileHeight
        val zoomX = (zoomWidth * x / textureWidth).toInt()
        val zoomY = (zoomHeight * y / textureHeight).toInt()
        return Pair(zoomX, zoomY)
    }

    /**
     * @return the grid from the [tiles] with missing tiles created with empty content
     */
    private fun createRows(): List<List<Tile>> {
        val grouped = tiles.groupBy { it.gridY }
        val grid = mutableListOf<List<Tile>>()
        for (y in startY..endY) {
            val group = grouped[y] ?: emptyList()
            val row =
                (startX..endX).map { x -> group.firstOrNull { tile -> tile.gridX == x } ?: Tile(gridX = x, gridY = y, width = tileWidth, height = tileHeight, zoom = zoom) }
            grid.add(row)
        }
        return grid
    }
}