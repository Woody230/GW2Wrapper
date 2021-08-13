package com.bselzer.library.gw2.v2.model.common.guild.log

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("rank_change")
data class RankChangeLog(
    /**
     * The account name of the guild member who changed the [user]'s rank.
     */
    @SerialName("changed_by")
    val changedBy: String = "",

    /**
     * The name of the old rank.
     */
    @SerialName("old_rank")
    val oldRank: String = "",

    /**
     * The name of the new rank.
     */
    @SerialName("new_rank")
    val newRank: String = ""
) : GuildLog()