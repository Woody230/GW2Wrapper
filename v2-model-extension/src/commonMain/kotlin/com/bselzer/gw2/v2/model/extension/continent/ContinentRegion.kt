package com.bselzer.gw2.v2.model.extension.continent

import com.bselzer.gw2.v2.model.continent.ContinentRegion
import com.bselzer.gw2.v2.model.extension.internal.toDigon
import com.bselzer.gw2.v2.model.extension.internal.toPoint2D
import com.bselzer.ktx.geometry.dimension.bi.polygon.Digon
import com.bselzer.ktx.geometry.dimension.bi.position.Point2D

/**
 * The [ContinentRegion.labelCoordinates] as a [Point2D].
 */
fun ContinentRegion.labelCoordinates(): Point2D = labelCoordinates.toPoint2D()

/**
 * The [ContinentRegion.continentRectangle] as a [Digon].
 */
fun ContinentRegion.continentRectangle(): Digon = continentRectangle.toDigon()