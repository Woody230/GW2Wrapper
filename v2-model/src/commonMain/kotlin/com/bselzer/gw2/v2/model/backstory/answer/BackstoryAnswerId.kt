package com.bselzer.gw2.v2.model.backstory.answer

import com.bselzer.gw2.v2.model.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class BackstoryAnswerId(override val value: String = "") : StringIdentifier