package com.bselzer.gw2.v2.tile.model.position

import com.bselzer.ktx.geometry.dimension.bi.position.Coordinates2D
import com.bselzer.ktx.geometry.dimension.bi.position.Point2D
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * The absolute position within the dimensions of the texture for the grid's zoom level.
 */
@Serializable
@JvmInline
value class ScaledPosition(private val value: Point2D) : Coordinates2D {
    override val x: Double
        get() = value.x

    override val y: Double
        get() = value.y

    override fun toString(): String = value.toString()
}