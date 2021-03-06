package com.bselzer.gw2.v2.model.dungeon

import com.bselzer.ktx.value.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

// TODO enum and extension
/**
 * The name of a [Dungeon].
 */
@Serializable
@JvmInline
value class DungeonId(override val value: String = "") : StringIdentifier {
    override fun toString(): String = value
}