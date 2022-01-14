package com.bselzer.gw2.v2.model.extension.continent

import com.bselzer.gw2.v2.model.continent.ContinentFloor
import com.bselzer.gw2.v2.model.extension.internal.toDigon
import com.bselzer.gw2.v2.model.extension.internal.toDimension2D
import com.bselzer.ktx.geometry.dimension.bi.Dimension2D
import com.bselzer.ktx.geometry.dimension.bi.polygon.Digon

/**
 * The [ContinentFloor.textureDimensions] as a [Dimension2D].
 */
fun ContinentFloor.textureDimensions(): Dimension2D = textureDimensions.toDimension2D()

/**
 * The [ContinentFloor.clampedView] as a [Digon].
 */
fun ContinentFloor.clampedView(): Digon = clampedView.toDigon()