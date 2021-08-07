package com.bselzer.library.gw2.v2.model.common.pvp.leaderboard

import com.bselzer.library.kotlin.extension.datetime.common.function.minValue
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpLeaderboard(
    /**
     * The account name.
     */
    @SerialName("name")
    val name: String = "",

    /**
     * The rank for the player or guild.
     */
    @SerialName("rank")
    val rank: Int = 0,

    /**
     * The date when the rank was achieved.
     */
    @SerialName("date")
    val achievedAt: LocalDateTime = LocalDateTime.minValue(),

    @SerialName("scores")
    val scores: List<PvpLeaderboardScore> = emptyList()
)