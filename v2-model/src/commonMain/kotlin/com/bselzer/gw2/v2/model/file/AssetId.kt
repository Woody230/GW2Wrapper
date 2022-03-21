package com.bselzer.gw2.v2.model.file

import com.bselzer.gw2.v2.model.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class AssetId(override val value: String = "") : StringIdentifier {
    override fun toString(): String = value
}