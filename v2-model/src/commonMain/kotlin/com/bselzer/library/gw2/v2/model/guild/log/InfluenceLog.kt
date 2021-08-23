package com.bselzer.library.gw2.v2.model.guild.log

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("influence")
data class InfluenceLog(
    @SerialName("activity")
    val activity: String = "",

    @SerialName("total_participants")
    val totalParticipants: Int = 0,

    /**
     * The account names of the participants.
     */
    @SerialName("participants")
    val participants: List<String> = emptyList()
) : GuildLog()