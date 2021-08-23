package com.bselzer.library.gw2.v2.model.pvp.standing

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpStandings(
    @SerialName("current")
    val current: List<CurrentStanding> = emptyList(),

    @SerialName("best")
    val best: List<BestStanding> = emptyList(),

    /**
     * The id of the season in the form of a UUID.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">the wiki</a>
     */
    @SerialName("season_id")
    val seasonId: String = ""
)