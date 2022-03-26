package com.bselzer.gw2.v2.model.pvp.season

import com.bselzer.gw2.v2.model.pvp.season.division.PvpDivision
import com.bselzer.gw2.v2.model.pvp.season.leaderboard.PvpSeasonLeaderboard
import com.bselzer.gw2.v2.model.pvp.season.rank.PvpSeasonRank
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpSeason(
    /**
     * The id in the form of a UUID.
     */
    @SerialName("id")
    override val id: PvpSeasonId = PvpSeasonId(),

    @SerialName("name")
    val name: String = "",

    @SerialName("start")
    val startAt: Instant = Instant.DISTANT_PAST,

    @SerialName("end")
    val endAt: Instant = Instant.DISTANT_PAST,

    /**
     * Whether this season is currently active.
     */
    @SerialName("active")
    val isActive: Boolean = false,

    @SerialName("divisions")
    val divisions: List<PvpDivision> = emptyList(),

    @SerialName("leaderboards")
    val leaderboards: List<PvpSeasonLeaderboard> = emptyList(),

    @SerialName("ranks")
    val ranks: List<PvpSeasonRank> = emptyList()
) : Identifiable<String>