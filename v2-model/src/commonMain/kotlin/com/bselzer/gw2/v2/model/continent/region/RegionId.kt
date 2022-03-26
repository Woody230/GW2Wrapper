package com.bselzer.gw2.v2.model.continent.region

import com.bselzer.ktx.value.identifier.IntIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class RegionId(override val value: Int = 0) : IntIdentifier {
    override fun toString(): String = value.toString()
}