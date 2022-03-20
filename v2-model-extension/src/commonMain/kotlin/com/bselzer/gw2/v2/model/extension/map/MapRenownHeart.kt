package com.bselzer.gw2.v2.model.extension.map

import com.bselzer.gw2.v2.model.continent.map.heart.RenownHeart
import com.bselzer.gw2.v2.model.extension.internal.toPoint2D
import com.bselzer.ktx.geometry.dimension.bi.position.Point2D

/**
 * The [RenownHeart.coordinates] as a [Point2D].
 */
fun RenownHeart.coordinates(): Point2D = coordinates.toPoint2D()

/**
 * The [RenownHeart.bounds] as a collection of [Point2D].
 */
fun RenownHeart.bounds(): List<Point2D> = bounds.map { components -> components.toPoint2D() }