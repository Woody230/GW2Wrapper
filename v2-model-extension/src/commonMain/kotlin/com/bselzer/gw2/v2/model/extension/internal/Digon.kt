package com.bselzer.gw2.v2.model.extension.internal

import com.bselzer.ktx.geometry.dimension.bi.polygon.Digon
import com.bselzer.ktx.geometry.dimension.bi.serialization.DigonSerializer
import kotlinx.serialization.SerializationException

private val serializer = DigonSerializer()

internal fun List<List<Double>>.toDigon(): Digon = try {
    serializer.deserialize(this)
} catch (ex: SerializationException) {
    Digon()
}