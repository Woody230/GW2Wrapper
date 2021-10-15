package com.bselzer.library.gw2.v2.tile.model.response

/**
 * The tiles within the grid.
 */
data class TileGrid(
    // TODO use dimension and position 2d (migrate to KotlinExtensions)

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