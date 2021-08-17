package com.bselzer.library.gw2.v2.model.common.pvp.season

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import com.bselzer.library.gw2.v2.model.common.pvp.season.leaderboard.PvpSeasonLeaderboard
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpSeason(
    /**
     * The id in the form of a UUID.
     */
    @SerialName("id")
    override val id: String = "",

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