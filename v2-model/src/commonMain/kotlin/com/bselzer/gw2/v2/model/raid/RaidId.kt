package com.bselzer.gw2.v2.model.raid

import com.bselzer.gw2.v2.model.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * The name of the raid.
 */
// TODO enum and extension
@Serializable
@JvmInline
value class RaidId(override val value: String = "") : StringIdentifier {
    override fun toString(): String = value
}