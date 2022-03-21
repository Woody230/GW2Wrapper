package com.bselzer.gw2.v2.model.mini

import com.bselzer.gw2.v2.model.identifier.IntIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class MiniId(override val value: Int = 0) : IntIdentifier {
    override fun toString(): String = value.toString()
}