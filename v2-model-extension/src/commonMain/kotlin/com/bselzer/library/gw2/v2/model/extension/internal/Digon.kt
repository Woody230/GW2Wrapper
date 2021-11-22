package com.bselzer.library.gw2.v2.model.extension.internal

import com.bselzer.library.kotlin.extension.geometry.dimension.bi.polygon.Digon
import com.bselzer.library.kotlin.extension.geometry.dimension.bi.serialization.DigonSerializer
import kotlinx.serialization.SerializationException

private val serializer = DigonSerializer()

internal fun List<List<Double>>.toDigon(): Digon = try {
    serializer.deserialize(this)
} catch (ex: SerializationException) {
    Digon()
}