package com.bselzer.gw2.v2.model.account.luck

import com.bselzer.ktx.value.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * This id will always be "luck" when retrieved from the API.
 */
@Serializable
@JvmInline
value class LuckId(override val value: String = "") : StringIdentifier {
    override fun toString(): String = value
}