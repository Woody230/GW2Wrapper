package com.bselzer.library.gw2.v2.model.extension.internal

import com.bselzer.library.kotlin.extension.geometry.dimension.bi.position.Point2D
import com.bselzer.library.kotlin.extension.geometry.dimension.bi.serialization.Point2DSerializer
import kotlinx.serialization.SerializationException

private val serializer = Point2DSerializer()

internal fun List<Double>.toPoint2D(): Point2D = try {
    serializer.deserialize(this)
} catch (ex: SerializationException) {
    Point2D()
}