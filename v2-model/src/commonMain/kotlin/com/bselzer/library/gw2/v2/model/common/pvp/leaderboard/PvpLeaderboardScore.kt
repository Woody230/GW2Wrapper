package com.bselzer.library.gw2.v2.model.common.pvp.leaderboard

import com.bselzer.library.gw2.v2.model.common.pvp.season.leaderboard.PvpLadderScoring
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
    val id: String = "",

    @SerialName("value")
    val value: Int = 0
)