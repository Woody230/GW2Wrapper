package com.bselzer.gw2.v2.model.extension.map

import com.bselzer.gw2.v2.model.continent.map.mastery.MasteryPoint
import com.bselzer.gw2.v2.model.extension.internal.toPoint2D
import com.bselzer.ktx.geometry.dimension.bi.position.Point2D

/**
 * The [MasteryPoint.coordinates] as a [Point2D].
 */
fun MasteryPoint.coordinates(): Point2D = coordinates.toPoint2D()