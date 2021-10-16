package com.bselzer.library.gw2.v2.tile.model.response

/**
 * Represents a tile within the grid.
 */
data class Tile(
    /**
     * The horizontal position within the texture.
     */
    val x: Int = 0,

    /**
     * The vertical position within the texture.
     */
    val y: Int = 0,

    /**
     * The content.
     */
    val content: ByteArray = ByteArray(0)
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Tile

        if (x != other.x) return false
        if (y != other.y) return false
        if (!content.contentEquals(other.content)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        result = 31 * result + content.contentHashCode()
        return result
    }
}