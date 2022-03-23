package com.bselzer.gw2.v2.model.enumeration.wrapper

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class MountName(val value: String = "") {
    override fun toString() = value
}