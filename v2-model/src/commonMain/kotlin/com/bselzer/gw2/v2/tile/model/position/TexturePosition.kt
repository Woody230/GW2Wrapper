package com.bselzer.gw2.v2.tile.model.position

import com.bselzer.ktx.geometry.dimension.bi.position.Coordinates2D
import com.bselzer.ktx.geometry.dimension.bi.position.Point2D
import com.bselzer.ktx.serialization.serializer.Point2DSerializer
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * The absolute position within the full dimensions of the texture, equivalent to the dimensions at the maximum zoom level.
 */
@Serializable
@JvmInline
value class TexturePosition(
    @Serializable(with = Point2DSerializer::class)
    private val value: Point2D = Point2D()
) : Coordinates2D {
    constructor(x: Double, y: Double) : this(Point2D(x, y))

    override val x: Double
        get() = value.x

    override val y: Double
        get() = value.y

    override fun toString(): String = value.toString()
}