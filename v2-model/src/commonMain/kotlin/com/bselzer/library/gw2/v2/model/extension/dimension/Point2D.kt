package com.bselzer.library.gw2.v2.model.extension.dimension

import com.bselzer.library.gw2.v2.model.extension.serialization.Point2DSerializer
import kotlinx.serialization.Serializable

@Serializable(with = Point2DSerializer::class)
data class Point2D(
    val x: Double = 0.0,
    val y: Double = 0.0
)