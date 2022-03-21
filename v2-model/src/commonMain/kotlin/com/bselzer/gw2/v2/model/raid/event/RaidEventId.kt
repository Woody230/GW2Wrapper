package com.bselzer.gw2.v2.model.raid.event

import com.bselzer.gw2.v2.model.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * The name of the event/encounter.
 */
// TODO enum/extension
@Serializable
@JvmInline
value class RaidEventId(override val value: String = "") : StringIdentifier {
    override fun toString(): String = value
}