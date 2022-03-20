package com.bselzer.gw2.v2.model.pvp.hero

import com.bselzer.gw2.v2.model.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class PvpHeroId(override val value: String = "") : StringIdentifier