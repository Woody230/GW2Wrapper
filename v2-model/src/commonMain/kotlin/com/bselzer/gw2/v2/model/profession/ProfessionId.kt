package com.bselzer.gw2.v2.model.profession

import com.bselzer.gw2.v2.model.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class ProfessionId(override val value: String = "") : StringIdentifier