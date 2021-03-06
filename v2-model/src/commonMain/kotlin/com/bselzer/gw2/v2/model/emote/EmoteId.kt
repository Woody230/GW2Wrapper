package com.bselzer.gw2.v2.model.emote

import com.bselzer.ktx.value.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

// TODO enum and extension
/**
 * The name of the emote.
 */
@Serializable
@JvmInline
value class EmoteId(override val value: String = "") : StringIdentifier {
    override fun toString(): String = value
}