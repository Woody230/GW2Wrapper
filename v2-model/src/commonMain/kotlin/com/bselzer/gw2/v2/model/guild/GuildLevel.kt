package com.bselzer.gw2.v2.model.guild

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class GuildLevel(val value: Int = 0) {
    override fun toString() = value.toString()
}