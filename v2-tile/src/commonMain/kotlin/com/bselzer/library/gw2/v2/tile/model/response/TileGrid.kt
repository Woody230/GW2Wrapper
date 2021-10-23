package com.bselzer.library.gw2.v2.tile.model.response

import com.bselzer.library.gw2.v2.tile.model.request.TileGridRequest

/**
 * The tiles within the grid.
 */
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
     * The subset of tiles with content.
     */
    val tiles: List<Tile> = emptyList(),
) {
    /**
     * All of the tiles within the boundary.
     */
    val grid: List<List<Tile>> = createGrid()

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
        request.tileWidth,
        request.tileHeight,
        request.startX,
        request.endX,
        request.startY,
        request.endY,
        tiles
    )

    /**
     * @return the grid from the [tiles] with missing tiles created with empty content
     */
    private fun createGrid(): List<List<Tile>> {
        val grouped = tiles.groupBy { it.y }
        val grid = mutableListOf<List<Tile>>()
        for (y in startY..endY) {
            val group = grouped[y] ?: emptyList()
            val row = (startX..endX).map { x -> group.firstOrNull { tile -> tile.x == x } ?: Tile() }
            grid.add(row)
        }
        return grid
    }
}