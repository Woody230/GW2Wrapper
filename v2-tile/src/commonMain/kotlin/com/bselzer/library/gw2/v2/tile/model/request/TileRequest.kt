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
     * The horizontal position within the texture.
     */
    val x: Int = 0,

    /**
     * The vertical position within the texture.
     */
    val y: Int = 0,

    /**
     * The zoom level.
     */
    val zoom: Int = 0,
)