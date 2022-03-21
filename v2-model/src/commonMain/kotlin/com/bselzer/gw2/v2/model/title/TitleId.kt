package com.bselzer.gw2.v2.model.title

import com.bselzer.gw2.v2.model.identifier.IntIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class TitleId(override val value: Int = 0) : IntIdentifier {
    override fun toString(): String = value.toString()
}