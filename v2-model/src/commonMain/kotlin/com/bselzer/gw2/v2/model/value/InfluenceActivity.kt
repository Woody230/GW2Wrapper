package com.bselzer.gw2.v2.model.value

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class InfluenceActivity(val value: String = "") {
    override fun toString(): String = value
}