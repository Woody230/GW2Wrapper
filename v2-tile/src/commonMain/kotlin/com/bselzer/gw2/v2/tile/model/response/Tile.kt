package com.bselzer.gw2.v2.tile.model.response

import com.bselzer.gw2.v2.tile.model.request.TileRequest
import kotlinx.serialization.Serializable

/**
 * Represents a tile within the grid.
 */
@Serializable
data class Tile(
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

    /**
     * The content.
     */
    val content: ByteArray = ByteArray(0)
) {
    /**
     * Creates a new instance using the data from the [request].
     */
    constructor(request: TileRequest, content: ByteArray = ByteArray(0)) : this(request.gridX, request.gridY, request.width, request.height, request.zoom, content)

    /**
     * The absolute horizontal position within the texture.
     */
    val textureX: Int = gridX * width

    /**
     * The absolute vertical position within the texture.
     */
    val textureY: Int = gridY * height

    /**
     * @return true if the texture position is within the bounds of this tile
     * @see [TileGrid.absoluteContains] for a coordinate scaled check
     */
    fun absoluteContains(x: Int, y: Int): Boolean {
        val startX = textureX
        val startY = textureY
        val endX = textureX + width
        val endY = textureY + height
        return x in startX..endX && y in startY..endY
    }

    /**
     * @return the relative position within the bounds of the tile of a texture position
     * @see [absoluteContains] to determine if the position exists within the bounds of the tile
     */
    fun absoluteBounded(x: Int, y: Int): Pair<Int, Int> = Pair(x % width, y % height)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Tile

        if (gridX != other.gridX) return false
        if (gridY != other.gridY) return false
        if (zoom != other.zoom) return false

        return true
    }

    override fun hashCode(): Int {
        var result = gridX
        result = 31 * result + gridY
        result = 31 * result + zoom
        return result
    }
}