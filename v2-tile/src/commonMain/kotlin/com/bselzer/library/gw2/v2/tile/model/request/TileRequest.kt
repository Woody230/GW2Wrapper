package com.bselzer.library.gw2.v2.tile.model.request

import com.bselzer.library.gw2.v2.tile.model.response.Tile
import kotlinx.serialization.Serializable

/**
 * Represents a request for getting [Tile] content.
 */
@Serializable
data class TileRequest(
    /**
     * The request.
     */
    val url: String,

    /**
     * The relative horizontal position within the texture.
     */
    val gridX: Int,

    /**
     * The relative vertical position within the texture.
     */
    val gridY: Int,

    /**
     * The width.
     */
    val width: Int,

    /**
     * The height.
     */
    val height: Int,

    /**
     * The zoom level.
     */
    val zoom: Int,
)