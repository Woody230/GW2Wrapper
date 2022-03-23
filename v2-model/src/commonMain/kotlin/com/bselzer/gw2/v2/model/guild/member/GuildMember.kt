package com.bselzer.gw2.v2.model.guild.member

import com.bselzer.gw2.v2.model.account.AccountName
import com.bselzer.gw2.v2.model.guild.rank.GuildRankId
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildMember(
    /**
     * The account name of the player.
     */
    @SerialName("name")
    val name: AccountName = AccountName(),

    /**
     * The name of the rank.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/ranks">the wiki</a>
     */
    @SerialName("rank")
    val rank: GuildRankId = GuildRankId(),

    /**
     * The date and time the player joined the guild.
     */
    @SerialName("joined")
    val joinedAt: Instant = Instant.DISTANT_PAST
)