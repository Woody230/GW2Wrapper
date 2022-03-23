package com.bselzer.gw2.v2.model.enumeration.wrapper

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class TraitTier(val value: Int = Int.MIN_VALUE) {
    override fun toString() = value.toString()
}