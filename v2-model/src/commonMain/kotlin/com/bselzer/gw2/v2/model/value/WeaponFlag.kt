package com.bselzer.gw2.v2.model.value

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class WeaponFlag(val value: String = "") {
    override fun toString() = value
}