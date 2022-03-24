package com.bselzer.gw2.v2.model.wrapper

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class Url(val value: String = "") {
    override fun toString() = value
}