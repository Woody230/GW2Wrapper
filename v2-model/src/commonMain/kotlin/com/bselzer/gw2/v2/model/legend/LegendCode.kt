package com.bselzer.gw2.v2.model.legend

import com.bselzer.gw2.v2.model.identifier.ByteIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class LegendCode(override val value: Byte = 0) : ByteIdentifier {
    override fun toString(): String = value.toString()
}