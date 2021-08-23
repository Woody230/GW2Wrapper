package com.bselzer.library.gw2.v2.model.guild.log

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("motd")
data class MessageOfTheDayLog(
    /**
     * The new message of the day.
     */
    @SerialName("motd")
    val message: String = ""
) : GuildLog()