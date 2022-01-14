package com.bselzer.gw2.v2.model.guild.log

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The [user] has joined the guild.
 */
@Serializable
@SerialName("joined")
class JoinedLog : GuildLog()