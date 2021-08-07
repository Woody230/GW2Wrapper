package com.bselzer.library.gw2.v2.model.common.pvp.season.leaderboard

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpSeasonLeaderboard(
    @SerialName("ladder")
    val ladder: PvpLadder = PvpLadder()
)