package com.bselzer.library.gw2.v2.model.extension.map

import com.bselzer.library.gw2.v2.model.continent.map.MapSector
import com.bselzer.library.gw2.v2.model.extension.internal.toPoint2D
import com.bselzer.library.kotlin.extension.geometry.dimension.bi.position.Point2D

/**
 * The [MapSector.coordinates] as a [Point2D].
 */
fun MapSector.coordinates(): Point2D = coordinates.toPoint2D()

/**
 * The [MapSector.bounds] as a collection of [Point2D].
 */
fun MapSector.bounds(): List<Point2D> = bounds.map { components -> components.toPoint2D() }