package com.bselzer.gw2.v2.model.account

import com.bselzer.gw2.v2.model.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class AccountId(override val value: String = "") : StringIdentifier