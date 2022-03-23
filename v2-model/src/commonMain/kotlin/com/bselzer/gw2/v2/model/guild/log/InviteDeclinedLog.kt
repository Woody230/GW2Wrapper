package com.bselzer.gw2.v2.model.guild.log

import com.bselzer.gw2.v2.model.account.AccountName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("invite_declined")
data class InviteDeclinedLog(
    /**
     * The account name of the player who declined the invitation.
     */
    @SerialName("declined_by")
    val declinedBy: AccountName = AccountName()
) : GuildLog()