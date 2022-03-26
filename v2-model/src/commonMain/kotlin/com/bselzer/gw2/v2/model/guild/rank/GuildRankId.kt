package com.bselzer.gw2.v2.model.guild.rank

import com.bselzer.ktx.value.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * The name of the rank given by the leader.
 */
@Serializable
@JvmInline
value class GuildRankId(override val value: String = "") : StringIdentifier {
    override fun toString(): String = value
}