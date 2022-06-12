package com.bselzer.gw2.v2.tile.model.position

/**
 * Represents the bounds of rectangular texture with corners [topLeft], [topRight], [bottomLeft] and [bottomRight].
 */
interface TextureBound {
    val topLeft: TexturePosition
    val topRight: TexturePosition
    val bottomLeft: TexturePosition
    val bottomRight: TexturePosition
}