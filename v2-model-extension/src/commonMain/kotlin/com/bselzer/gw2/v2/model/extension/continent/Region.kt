package com.bselzer.gw2.v2.model.extension.continent

import com.bselzer.gw2.v2.model.continent.region.Region
import com.bselzer.gw2.v2.model.extension.internal.toDigon
import com.bselzer.gw2.v2.model.extension.internal.toPoint2D
import com.bselzer.ktx.geometry.dimension.bi.polygon.Digon
import com.bselzer.ktx.geometry.dimension.bi.position.Point2D

/**
 * The [Region.labelCoordinates] as a [Point2D].
 */
fun Region.labelCoordinates(): Point2D = labelCoordinates.toPoint2D()

/**
 * The [Region.continentRectangle] as a [Digon].
 */
fun Region.continentRectangle(): Digon = continentRectangle.toDigon()