package com.bselzer.gw2.v2.tile.model.request

import com.bselzer.gw2.v2.tile.model.position.GridPosition
import com.bselzer.gw2.v2.tile.model.response.Tile
import com.bselzer.ktx.geometry.dimension.bi.Dimension2D
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
     * The relative position within the grid.
     */
    val gridPosition: GridPosition,

    /**
     * The width and height.
     */
    val size: Dimension2D,

    /**
     * The zoom level.
     */
    val zoom: Int,
)