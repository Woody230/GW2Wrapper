package com.bselzer.gw2.v2.model.tile.request

import com.bselzer.gw2.v2.model.tile.position.GridPosition
import com.bselzer.ktx.geometry.dimension.bi.Dimension2D
import com.bselzer.ktx.serialization.serializer.Dimension2DSerializer
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
    @Serializable(with = Dimension2DSerializer::class)
    val size: Dimension2D,

    /**
     * The zoom level.
     */
    val zoom: Int,
)