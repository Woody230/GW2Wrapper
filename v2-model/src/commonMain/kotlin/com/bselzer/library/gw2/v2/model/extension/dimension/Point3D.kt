package com.bselzer.library.gw2.v2.model.extension.dimension

import com.bselzer.library.gw2.v2.model.extension.serialization.Point3DSerializer
import kotlinx.serialization.Serializable

@Serializable(with = Point3DSerializer::class)
data class Point3D(
    val x: Double = 0.0,
    val y: Double = 0.0,
    val z: Double = 0.0
)