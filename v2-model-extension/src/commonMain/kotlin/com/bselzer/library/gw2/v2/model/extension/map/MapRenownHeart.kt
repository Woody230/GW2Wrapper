package com.bselzer.library.gw2.v2.model.extension.map

import com.bselzer.library.gw2.v2.model.continent.map.MapRenownHeart
import com.bselzer.library.gw2.v2.model.extension.internal.toPoint2D
import com.bselzer.library.kotlin.extension.geometry.dimension.bi.position.Point2D

/**
 * The [MapRenownHeart.coordinates] as a [Point2D].
 */
fun MapRenownHeart.coordinates(): Point2D = coordinates.toPoint2D()

/**
 * The [MapRenownHeart.bounds] as a collection of [Point2D].
 */
fun MapRenownHeart.bounds(): List<Point2D> = bounds.map { components -> components.toPoint2D() }