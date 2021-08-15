package com.bselzer.library.gw2.v2.model.common.extension.serialization

import com.bselzer.library.gw2.v2.model.common.extension.dimension.Dimension2D
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * A serializer for converting an array into a two-dimensional size.
 */
class Dimension2DSerializer : KSerializer<Dimension2D>
{
    /**
     * The serializer of the 2D dimension data.
     */
    private val serializer = ListSerializer(Double.serializer())

    override val descriptor: SerialDescriptor = serializer.descriptor

    override fun deserialize(decoder: Decoder): Dimension2D
    {
        val list = serializer.deserialize(decoder)
        return Dimension2D(list.getOrElse(0) { 0.0 }, list.getOrElse(1) { 0.0 })
    }

    override fun serialize(encoder: Encoder, value: Dimension2D)
    {
        val list = listOf(value.width, value.height)
        serializer.serialize(encoder, list)
    }
}