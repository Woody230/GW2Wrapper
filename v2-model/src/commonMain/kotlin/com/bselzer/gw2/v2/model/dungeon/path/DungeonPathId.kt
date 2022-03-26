package com.bselzer.gw2.v2.model.dungeon.path

import com.bselzer.ktx.value.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

// TODO enum and extension
/**
 * The name of a [DungeonPath].
 */
@Serializable
@JvmInline
value class DungeonPathId(override val value: String = "") : StringIdentifier {
    override fun toString(): String = value
}