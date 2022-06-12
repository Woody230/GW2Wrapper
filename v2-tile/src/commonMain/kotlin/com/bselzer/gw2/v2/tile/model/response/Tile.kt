package com.bselzer.gw2.v2.tile.model.response

import com.bselzer.gw2.v2.tile.model.position.GridPosition
import com.bselzer.gw2.v2.tile.model.position.TexturePosition
import com.bselzer.gw2.v2.tile.model.request.TileRequest
import com.bselzer.ktx.geometry.dimension.bi.Dimension2D
import com.bselzer.ktx.geometry.dimension.bi.position.Point2D
import kotlinx.serialization.Serializable

/**
 * Represents a tile within the grid.
 */
@Serializable
data class Tile(
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

    /**
     * The image content.
     */
    val content: ByteArray = ByteArray(0)
) {
    /**
     * Creates a new instance using the data from the [request].
     */
    constructor(
        request: TileRequest,
        content: ByteArray = ByteArray(0)
    ) : this(
        gridPosition = request.gridPosition,
        size = request.size,
        zoom = request.zoom,
        content = content
    )

    /**
     * The absolute position within the texture.
     */
    val texturePosition: TexturePosition = TexturePosition(
        value = Point2D(
            x = gridPosition.x * size.width,
            y = gridPosition.y * size.height
        )
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Tile

        if (gridPosition != other.gridPosition) return false
        if (zoom != other.zoom) return false

        return true
    }

    override fun hashCode(): Int {
        var result = gridPosition.hashCode()
        result = 31 * result + zoom
        return result
    }
}