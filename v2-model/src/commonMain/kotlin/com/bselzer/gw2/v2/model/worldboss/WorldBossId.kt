package com.bselzer.gw2.v2.model.worldboss

import com.bselzer.gw2.v2.model.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

// TODO enum/extension
@Serializable
@JvmInline
value class WorldBossId(override val value: String = "") : StringIdentifier {
    override fun toString(): String = value
}