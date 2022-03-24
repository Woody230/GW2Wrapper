package com.bselzer.gw2.v2.model.character

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class CharacterLevel(val value: Int = 1) {
    override fun toString() = value.toString()
}