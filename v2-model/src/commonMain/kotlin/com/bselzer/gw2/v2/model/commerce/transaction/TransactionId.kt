package com.bselzer.gw2.v2.model.commerce.transaction

import com.bselzer.gw2.v2.model.identifier.LongIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class TransactionId(override val value: Long = 0) : LongIdentifier {
    override fun toString(): String = value.toString()
}