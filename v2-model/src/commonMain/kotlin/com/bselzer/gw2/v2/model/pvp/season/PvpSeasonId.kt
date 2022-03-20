package com.bselzer.gw2.v2.model.pvp.season

import com.bselzer.gw2.v2.model.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class PvpSeasonId(override val value: String = "") : StringIdentifier