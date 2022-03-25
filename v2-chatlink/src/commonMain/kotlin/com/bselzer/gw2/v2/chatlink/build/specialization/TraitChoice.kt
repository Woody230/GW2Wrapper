package com.bselzer.gw2.v2.chatlink.build.specialization

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class TraitChoice(val value: Byte = 0) {
    override fun toString() = value.toString()
}