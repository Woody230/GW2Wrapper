package com.bselzer.gw2.v2.model.profession

import com.bselzer.ktx.value.identifier.IntIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class TrainingId(override val value: Int = 0) : IntIdentifier {
    override fun toString(): String = value.toString()
}