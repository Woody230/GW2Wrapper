package com.bselzer.library.gw2.v2.tile.model

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
     * The tiles.
     */
    val tiles: List<List<Tile>> = emptyList()
)