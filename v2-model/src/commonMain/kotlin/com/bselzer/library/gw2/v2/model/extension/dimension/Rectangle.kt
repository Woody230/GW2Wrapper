package com.bselzer.library.gw2.v2.model.extension.dimension

import com.bselzer.library.gw2.v2.model.extension.serialization.RectangleSerializer
import kotlinx.serialization.Serializable

@Serializable(with = RectangleSerializer::class)
data class Rectangle(val x1: Double = 0.0, val y1: Double = 0.0, val x2: Double = 0.0, val y2: Double = 0.0)