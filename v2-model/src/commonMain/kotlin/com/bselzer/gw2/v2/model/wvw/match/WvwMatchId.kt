package com.bselzer.gw2.v2.model.wvw.match

import com.bselzer.gw2.v2.model.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class WvwMatchId(override val value: String = "") : StringIdentifier