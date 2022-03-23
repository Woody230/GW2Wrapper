package com.bselzer.gw2.v2.model.guild.log

import com.bselzer.gw2.v2.model.account.AccountName
import com.bselzer.gw2.v2.model.guild.rank.GuildRankId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("rank_change")
data class RankChangeLog(
    /**
     * The account name of the guild member who changed the [user]'s rank.
     */
    @SerialName("changed_by")
    val changedBy: AccountName = AccountName(),

    /**
     * The name of the old rank.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/ranks">the wiki</a>
     */
    @SerialName("old_rank")
    val oldRank: GuildRankId = GuildRankId(),

    /**
     * The name of the new rank.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/ranks">the wiki</a>
     */
    @SerialName("new_rank")
    val newRank: GuildRankId = GuildRankId()
) : GuildLog()