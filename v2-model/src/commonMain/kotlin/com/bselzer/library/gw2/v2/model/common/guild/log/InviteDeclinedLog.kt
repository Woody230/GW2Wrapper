package com.bselzer.library.gw2.v2.model.common.guild.log

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("invite_declined")
data class InviteDeclinedLog(
    /**
     * The account name of the player who declined the invitation.
     */
    @SerialName("declined_by")
    val declinedBy: String = ""
) : GuildLog()