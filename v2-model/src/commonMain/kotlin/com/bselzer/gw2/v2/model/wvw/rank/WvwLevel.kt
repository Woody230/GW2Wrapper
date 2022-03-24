package com.bselzer.gw2.v2.model.wvw.rank

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class WvwLevel(val value: Int = 0) {
    override fun toString() = value.toString()
}