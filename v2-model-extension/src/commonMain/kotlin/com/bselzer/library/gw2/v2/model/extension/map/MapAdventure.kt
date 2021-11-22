package com.bselzer.library.gw2.v2.model.extension.map

import com.bselzer.library.gw2.v2.model.continent.map.MapAdventure
import com.bselzer.library.gw2.v2.model.extension.internal.toPoint2D
import com.bselzer.library.kotlin.extension.geometry.dimension.bi.position.Point2D

/**
 * The [MapAdventure.coordinates] as a [Point2D].
 */
fun MapAdventure.coordinates(): Point2D = coordinates.toPoint2D()