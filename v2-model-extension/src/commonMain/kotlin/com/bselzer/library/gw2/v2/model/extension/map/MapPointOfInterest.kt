package com.bselzer.library.gw2.v2.model.extension.map

import com.bselzer.library.gw2.v2.model.continent.map.MapPointOfInterest
import com.bselzer.library.gw2.v2.model.extension.internal.toPoint2D
import com.bselzer.library.kotlin.extension.geometry.dimension.bi.position.Point2D

/**
 * The [MapPointOfInterest.coordinates] as a [Point2D].
 */
fun MapPointOfInterest.coordinates(): Point2D = coordinates.toPoint2D()