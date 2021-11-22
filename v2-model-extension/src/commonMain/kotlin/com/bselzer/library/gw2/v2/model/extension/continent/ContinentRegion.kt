package com.bselzer.library.gw2.v2.model.extension.continent

import com.bselzer.library.gw2.v2.model.continent.ContinentRegion
import com.bselzer.library.gw2.v2.model.extension.internal.toDigon
import com.bselzer.library.gw2.v2.model.extension.internal.toPoint2D
import com.bselzer.library.kotlin.extension.geometry.dimension.bi.polygon.Digon
import com.bselzer.library.kotlin.extension.geometry.dimension.bi.position.Point2D

/**
 * The [ContinentRegion.labelCoordinates] as a [Point2D].
 */
fun ContinentRegion.labelCoordinates(): Point2D = labelCoordinates.toPoint2D()

/**
 * The [ContinentRegion.continentRectangle] as a [Digon].
 */
fun ContinentRegion.continentRectangle(): Digon = continentRectangle.toDigon()