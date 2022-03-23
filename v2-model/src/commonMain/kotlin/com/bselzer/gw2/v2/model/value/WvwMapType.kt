package com.bselzer.gw2.v2.model.value

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class WvwMapType(val value: String = "") {
    override fun toString() = value
}