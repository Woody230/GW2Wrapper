package com.bselzer.gw2.v2.model.currency

import com.bselzer.gw2.v2.model.identifier.IntIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class CurrencyId(override val value: Int = 0) : IntIdentifier