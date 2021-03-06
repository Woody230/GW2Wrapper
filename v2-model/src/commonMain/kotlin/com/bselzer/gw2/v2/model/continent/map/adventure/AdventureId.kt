package com.bselzer.gw2.v2.model.continent.map.adventure

import com.bselzer.ktx.value.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class AdventureId(override val value: String = "") : StringIdentifier {
    override fun toString(): String = value
}