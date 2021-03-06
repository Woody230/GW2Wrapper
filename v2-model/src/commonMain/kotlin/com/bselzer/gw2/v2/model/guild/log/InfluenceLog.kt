package com.bselzer.gw2.v2.model.guild.log

import com.bselzer.gw2.v2.model.account.AccountName
import com.bselzer.gw2.v2.model.enumeration.wrapper.InfluenceActivity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("influence")
data class InfluenceLog(
    @SerialName("activity")
    val activity: InfluenceActivity = InfluenceActivity(),

    @SerialName("total_participants")
    val totalParticipants: Int = 0,

    /**
     * The account names of the participants.
     */
    @SerialName("participants")
    val participants: List<AccountName> = emptyList()
) : GuildLog()