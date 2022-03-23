package com.bselzer.gw2.v2.model.value

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class SalvageKitDetailType(val value: String = "") {
    override fun toString() = value
}