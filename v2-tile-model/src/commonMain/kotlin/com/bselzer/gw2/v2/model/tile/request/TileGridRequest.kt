package com.bselzer.gw2.v2.model.tile.request

import com.bselzer.gw2.v2.model.tile.position.GridPosition
import com.bselzer.ktx.geometry.dimension.bi.Dimension2D
import com.bselzer.ktx.serialization.serializer.Dimension2DSerializer
import kotlinx.serialization.Serializable

/**
 * Represents a request for getting [TileGrid] content.
 */
@Serializable
data class TileGridRequest(
    /**
     * The size of each individual tile.
     */
    @Serializable(with = Dimension2DSerializer::class)
    val tileSize: Dimension2D,

    /**
     * The full dimensions of the texture, equivalent to the size at the max zoom level.
     */
    @Serializable(with = Dimension2DSerializer::class)
    val textureSize: Dimension2D,

    /**
     * The starting coordinates of the bound, representing the top left corner of the rectangle.
     */
    val topLeft: GridPosition,

    /**
     * The ending coordinates of the bound, representing the bottom right corner of the rectangle.
     */
    val bottomRight: GridPosition,

    /**
     * The zoom level.
     */
    val zoom: Int,

    /**
     * The requests for tiles.
     */
    val tileRequests: List<TileRequest>,
) {
    /**
     * Note that only existing [tileRequests] are used to form the bound.
     *
     * @return a request with existing tiles clamped by the given bounds
     */
    fun bounded(topLeft: GridPosition, bottomRight: GridPosition): TileGridRequest = copy(
        topLeft = topLeft,
        bottomRight = bottomRight,
        tileRequests = tileRequests.filter { tileRequest ->
            val column = tileRequest.gridPosition.x
            val row = tileRequest.gridPosition.y
            column in topLeft.x..bottomRight.x && row in topLeft.y..bottomRight.y
        }
    )
}