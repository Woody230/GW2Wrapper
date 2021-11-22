package com.bselzer.library.gw2.v2.model.extension.map

import com.bselzer.library.gw2.v2.model.continent.map.MapMasteryPoint
import com.bselzer.library.gw2.v2.model.extension.internal.toPoint2D
import com.bselzer.library.kotlin.extension.geometry.dimension.bi.position.Point2D

/**
 * The [MapMasteryPoint.coordinates] as a [Point2D].
 */
fun MapMasteryPoint.coordinates(): Point2D = coordinates.toPoint2D()