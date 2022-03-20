package com.bselzer.gw2.v2.model.extension.map

import com.bselzer.gw2.v2.model.continent.map.challenge.HeroChallenge
import com.bselzer.gw2.v2.model.extension.internal.toPoint2D
import com.bselzer.ktx.geometry.dimension.bi.position.Point2D

/**
 * The [HeroChallenge.coordinates] as a [Point2D].
 */
fun HeroChallenge.coordinates(): Point2D = coordinates.toPoint2D()