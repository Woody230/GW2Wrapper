package com.bselzer.gw2.v2.model.guild.log

import com.bselzer.gw2.v2.model.account.AccountName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The [user] has been invited to the guild.
 */
@Serializable
@SerialName("invited")
data class InvitedLog(
    /**
     * The account name of the guild member which invited the [user].
     */
    @SerialName("invited_by")
    val invitedBy: AccountName = AccountName()
) : GuildLog()