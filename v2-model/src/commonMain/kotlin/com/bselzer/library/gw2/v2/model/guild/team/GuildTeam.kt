package com.bselzer.library.gw2.v2.model.guild.team

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import com.bselzer.library.gw2.v2.model.pvp.PvpGame
import com.bselzer.library.gw2.v2.model.pvp.stat.StatAggregate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildTeam(
    /**
     * The id of the team unique to this guild only.
     */
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("members")
    val members: List<GuildTeamMember> = emptyList(),

    @SerialName("name")
    val name: String = "",

    /**
     * The total count of wins and losses.
     */
    @SerialName("aggregate")
    val totalAggregate: StatAggregate = StatAggregate(),

    /**
     * The ladder types mapped to an aggregate.
     */
    @SerialName("ladders")
    val ladderAggregate: Map<String, StatAggregate> = emptyMap(),

    /**
     * The games. The profession will always be omitted.
     */
    @SerialName("games")
    val games: List<PvpGame> = emptyList(),

    @SerialName("seasons")
    val seasons: List<GuildTeamSeason> = emptyList()
) : Identifiable<Int>