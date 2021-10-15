package com.bselzer.library.gw2.v2.tile.model.request

import com.bselzer.library.gw2.v2.tile.model.response.Tile

/**
 * Represents a request for getting [Tile] content.
 */
data class TileRequest(
    /**
     * The request.
     */
    val url: String = "",

    /**
     * The horizontal position within the grid.
     */
    val x: Int = 0,

    /**
     * The vertical position within the grid.
     */
    val y: Int = 0,
)