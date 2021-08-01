package com.bselzer.library.gw2.v2.model.common.serialization

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

/**
 * A serializer for seconds in the form of a [Duration]
 */
@ExperimentalTime
class SecondDurationSerializer : KSerializer<Duration>
{
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Duration", PrimitiveKind.LONG)

    override fun deserialize(decoder: Decoder): Duration = Duration.seconds(decoder.decodeLong())

    override fun serialize(encoder: Encoder, value: Duration)
    {
        encoder.encodeLong(value.inWholeSeconds)
    }
}