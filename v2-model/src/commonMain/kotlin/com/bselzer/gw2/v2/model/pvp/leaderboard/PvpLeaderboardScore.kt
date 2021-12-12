package com.bselzer.gw2.v2.model.pvp.leaderboard

import com.bselzer.gw2.v2.model.extension.base.Identifiable
import com.bselzer.gw2.v2.model.pvp.season.leaderboard.PvpLadderScoring
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpLeaderboardScore(
    /**
     * The id of the scoring method in the form of a UUID.
     * @see [PvpLadderScoring.id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">the wiki</a>
     */
    @SerialName("id")
    override val id: String = "",

    @SerialName("value")
    val value: Int = 0
) : Identifiable<String>