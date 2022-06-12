package com.bselzer.gw2.v2.tile.model.position

import com.bselzer.ktx.geometry.dimension.bi.polygon.Digon
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * The bounds of a rectangle formed by the [topLeft] and [bottomRight] coordinates.
 */
@Serializable
@JvmInline
value class TopLeftTextureBound(
    private val value: Digon = Digon()
) : TextureBound {
    override val topLeft: TexturePosition
        get() = TexturePosition(value.point1)

    override val bottomRight: TexturePosition
        get() = TexturePosition(value.point2)

    override val bottomLeft: TexturePosition
        get() = TexturePosition(x = topLeft.x, y = bottomRight.y)

    override val topRight: TexturePosition
        get() = TexturePosition(x = bottomRight.x, y = topLeft.y)
}