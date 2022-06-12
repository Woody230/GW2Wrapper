package com.bselzer.gw2.v2.tile.model.position

import com.bselzer.ktx.geometry.dimension.bi.position.Coordinates2D
import com.bselzer.ktx.geometry.dimension.bi.position.Point2D
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * The absolute position within the bounds of the grid coerced between the range of 0 to 1.
 */
@Serializable
@JvmInline
value class NormalizedPosition(private val value: Point2D) : Coordinates2D {
    override val x: Double
        get() = value.x.coerceIn(0.0, 1.0)

    override val y: Double
        get() = value.y.coerceIn(0.0, 1.0)
}