package com.bselzer.gw2.v2.model.account

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class AccountName(val value: String = "") {
    override fun toString() = value
}