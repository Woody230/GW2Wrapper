package com.bselzer.gw2.v2.model.extension.internal

import com.bselzer.ktx.geometry.dimension.tri.position.Point3D
import com.bselzer.ktx.geometry.dimension.tri.serialization.Point3DSerializer
import kotlinx.serialization.SerializationException

private val serializer = Point3DSerializer()

internal fun List<Double>.toPoint3D(): Point3D = try {
    serializer.deserialize(this)
} catch (ex: SerializationException) {
    Point3D()
}