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
     * The relative starting horizontal tile position.
     */
    val startX: Int = 0,

    /**
     * The relative ending horizontal tile position.
     */
    val endX: Int = 0,

    /**
     * The relative starting vertical tile position.
     */
    val startY: Int = 0,

    /**
     * The relative ending vertical tile position.
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
     * All of the tiles within the boundary by columns.
     */
    val columns: List<List<Tile>> = createColumns()

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
     * @return the tile at the relative [x] and [y] position within the [zoom] level, or null if it does not exist
     */
    fun getTileOrNull(x: Int, y: Int, zoom: Int): Tile? = tiles.firstOrNull { tile -> tile.gridX == x && tile.gridY == y && tile.zoom == zoom }

    /**
     * @return the tile at the relative [x] and [y] position within the [zoom] level, or a tile with empty content if it does not exist
     */
    fun getTileOrDefault(x: Int, y: Int, zoom: Int): Tile = getTileOrNull(x, y, zoom) ?: Tile(gridX = x, gridY = y, zoom = zoom, width = tileWidth, height = tileHeight)

    /**
     * @return the absolute position normalized to a range of 0 to 1 within the bounds of the grid
     */
    fun boundedNormalizeAbsolutePosition(x: Int, y: Int): Pair<Double, Double> {
        // NOTE: avoiding int division
        return x.toDouble() / width to y.toDouble() / height
    }

    /**
     * @return the absolute position normalized to a range of 0 to 1
     */
    fun normalizeAbsolutePosition(x: Int, y: Int): Pair<Double, Double> {
        // NOTE: avoiding int division
        return x.toDouble() / textureWidth to y.toDouble() / textureHeight
    }

    /**
     * @return the absolute position scaled to the bounds of the grid within the [zoom] level
     */
    fun boundedScaleAbsolutePosition(x: Int, y: Int): Pair<Int, Int> {
        val zoom = scaleAbsolutePosition(x, y)

        // Remove the excluded starting tiles.
        val scaledX = zoom.first - (startX * tileWidth)
        val scaledY = zoom.second - (startY * tileHeight)
        return Pair(scaledX, scaledY)
    }

    /**
     * @return the absolute position scaled to the absolute coordinates within the [zoom] level
     */
    fun scaleAbsolutePosition(x: Int, y: Int): Pair<Int, Int> {
        // Scale the coordinates to the current zoom level.
        val zoomWidth = 2.0.pow(zoom) * tileWidth
        val zoomHeight = 2.0.pow(zoom) * tileHeight
        val zoomX = (zoomWidth * x / textureWidth).toInt()
        val zoomY = (zoomHeight * y / textureHeight).toInt()
        return Pair(zoomX, zoomY)
    }

    /**
     * @return the grid, organized by row from the [tiles] with missing tiles created with empty content
     */
    private fun createRows(): List<List<Tile>> {
        val grouped = tiles.groupBy { it.gridY }
        val grid = mutableListOf<List<Tile>>()

        for (y in startY..endY) {
            val group = grouped[y] ?: emptyList()

            val row = (startX..endX).map { x ->
                group.firstOrNull { tile -> tile.gridX == x } ?: Tile(gridX = x, gridY = y, width = tileWidth, height = tileHeight, zoom = zoom)
            }

            grid.add(row)
        }
        return grid
    }

    /**
     * @return the grid, organized by column, from the [tiles] with missing tiles created with empty content
     */
    private fun createColumns(): List<List<Tile>> {
        val grouped = tiles.groupBy { it.gridX }
        val grid = mutableListOf<List<Tile>>()

        for (x in startX..endX) {
            val group = grouped[x] ?: emptyList()

            val column = (startY..endY).map { y ->
                group.firstOrNull { tile -> tile.gridY == y } ?: Tile(gridX = x, gridY = y, width = tileWidth, height = tileHeight, zoom = zoom)
            }

            grid.add(column)
        }

        return grid
    }
}