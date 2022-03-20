package com.bselzer.gw2.v2.model.extension.continent

import com.bselzer.gw2.v2.model.continent.floor.Floor
import com.bselzer.gw2.v2.model.extension.internal.toDigon
import com.bselzer.gw2.v2.model.extension.internal.toDimension2D
import com.bselzer.ktx.geometry.dimension.bi.Dimension2D
import com.bselzer.ktx.geometry.dimension.bi.polygon.Digon

/**
 * The [Floor.textureDimensions] as a [Dimension2D].
 */
fun Floor.textureDimensions(): Dimension2D = textureDimensions.toDimension2D()

/**
 * The [Floor.clampedView] as a [Digon].
 */
fun Floor.clampedView(): Digon = clampedView.toDigon()