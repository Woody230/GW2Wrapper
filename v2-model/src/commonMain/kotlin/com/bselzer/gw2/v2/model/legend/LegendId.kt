package com.bselzer.gw2.v2.model.legend

import com.bselzer.ktx.value.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class LegendId(override val value: String = "") : StringIdentifier {
    override fun toString(): String = value
}