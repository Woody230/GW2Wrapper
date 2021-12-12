package com.bselzer.gw2.v2.model.pvp.leaderboard

import kotlinx.datetime.Instant
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
    val achievedAt: Instant = Instant.DISTANT_PAST,

    @SerialName("scores")
    val scores: List<PvpLeaderboardScore> = emptyList()
)