package com.bselzer.gw2.v2.model.raid.wing

import com.bselzer.gw2.v2.model.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * The name of the raid wing.
 */
// TODO enum and extension
@Serializable
@JvmInline
value class RaidWingId(override val value: String = "") : StringIdentifier