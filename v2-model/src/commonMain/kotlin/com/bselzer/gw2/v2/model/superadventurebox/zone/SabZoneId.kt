package com.bselzer.gw2.v2.model.superadventurebox.zone

import com.bselzer.ktx.value.identifier.IntIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class SabZoneId(override val value: Int = 0) : IntIdentifier {
    override fun toString(): String = value.toString()
}