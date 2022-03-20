package com.bselzer.gw2.v2.model.quaggan

import com.bselzer.gw2.v2.model.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class QuagganId(override val value: String = "") : StringIdentifier