package com.bselzer.gw2.v2.model.tile.position

import com.bselzer.ktx.geometry.dimension.bi.polygon.Digon
import com.bselzer.ktx.serialization.serializer.DigonSerializer
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * The bounds of a rectangle formed by the [bottomLeft] and [topRight] coordinates.
 */
@Serializable
@JvmInline
value class BottomLeftTextureBound(
    @Serializable(with = DigonSerializer::class)
    private val value: Digon = Digon()
) : TextureBound {
    override val bottomLeft: TexturePosition
        get() = TexturePosition(value.point1)

    override val topRight: TexturePosition
        get() = TexturePosition(value.point2)

    override val bottomRight: TexturePosition
        get() = TexturePosition(x = topRight.x, y = bottomLeft.y)

    override val topLeft: TexturePosition
        get() = TexturePosition(x = bottomLeft.x, y = topRight.y)
}