package com.bselzer.gw2.v2.model.extension.internal

import com.bselzer.ktx.geometry.dimension.bi.Dimension2D
import com.bselzer.ktx.geometry.dimension.bi.serialization.Dimension2DSerializer
import kotlinx.serialization.SerializationException

private val serializer = Dimension2DSerializer()

internal fun List<Double>.toDimension2D(): Dimension2D = try {
    serializer.deserialize(this)
} catch (ex: SerializationException) {
    Dimension2D()
}