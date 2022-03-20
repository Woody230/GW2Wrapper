package com.bselzer.gw2.v2.model.pvp.season.leaderboard

import com.bselzer.gw2.v2.model.pvp.season.leaderboard.ladder.PvpLadder
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpSeasonLeaderboard(
    @SerialName("ladder")
    val ladder: PvpLadder = PvpLadder()
)