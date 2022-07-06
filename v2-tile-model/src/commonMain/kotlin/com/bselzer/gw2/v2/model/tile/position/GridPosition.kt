package com.bselzer.gw2.v2.model.tile.position

import kotlinx.serialization.Serializable

/**
 * The relative position within the grid.
 */
@Serializable
data class GridPosition(
    /**
     * The column.
     */
    val x: Int = 0,

    /**
     * The row.
     */
    val y: Int = 0
) {
    override fun toString(): String = "[$x,$y]"
}