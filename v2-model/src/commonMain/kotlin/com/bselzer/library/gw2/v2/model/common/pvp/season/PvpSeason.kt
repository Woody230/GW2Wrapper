package com.bselzer.library.gw2.v2.model.common.pvp.season

import com.bselzer.library.gw2.v2.model.common.pvp.season.leaderboard.PvpSeasonLeaderboard
import com.bselzer.library.kotlin.extension.datetime.common.function.minValue
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpSeason(
    /**
     * The id in the form of a UUID.
     */
    @SerialName("id")
    val id: String = "",

    @SerialName("name")
    val name: String = "",

    @SerialName("start")
    val startAt: LocalDateTime = LocalDateTime.minValue(),

    @SerialName("end")
    val endAt: LocalDateTime = LocalDateTime.minValue(),

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
)