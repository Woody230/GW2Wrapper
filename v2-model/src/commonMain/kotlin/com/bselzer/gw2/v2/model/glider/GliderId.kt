package com.bselzer.gw2.v2.model.glider

import com.bselzer.gw2.v2.model.identifier.IntIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class GliderId(override val value: Int = 0) : IntIdentifier {
    override fun toString(): String = value.toString()
}