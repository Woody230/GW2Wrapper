package com.bselzer.gw2.v2.model.pvp.game

import com.bselzer.gw2.v2.model.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class PvpGameId(override val value: String = "") : StringIdentifier