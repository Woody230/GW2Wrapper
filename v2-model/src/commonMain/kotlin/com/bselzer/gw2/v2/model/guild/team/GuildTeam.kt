package com.bselzer.gw2.v2.model.guild.team

import com.bselzer.gw2.v2.model.enumeration.wrapper.PvpLadderType
import com.bselzer.gw2.v2.model.pvp.game.PvpGame
import com.bselzer.gw2.v2.model.pvp.stat.StatAggregate
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildTeam(
    /**
     * The id of the team unique to this guild only.
     */
    @SerialName("id")
    override val id: GuildTeamId = GuildTeamId(),

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
    val ladderAggregate: Map<PvpLadderType, StatAggregate> = emptyMap(),

    /**
     * The games. The profession will always be omitted.
     */
    @SerialName("games")
    val games: List<PvpGame> = emptyList(),

    @SerialName("seasons")
    val seasons: List<GuildTeamSeason> = emptyList()
) : Identifiable<Int>