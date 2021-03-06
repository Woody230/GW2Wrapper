package com.bselzer.gw2.v2.model.guild.log

import com.bselzer.gw2.v2.model.account.AccountName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("kick")
data class KickLog(
    /**
     * The account name of the guild member who kicked the [user].
     */
    @SerialName("kicked_by")
    val kickedBy: AccountName = AccountName()
) : GuildLog()