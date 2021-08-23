package com.bselzer.library.gw2.v2.model.pvp.season.leaderboard

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpLadder(
    @SerialName("settings")
    val settings: PvpLadderSettings = PvpLadderSettings(),

    @SerialName("scorings")
    val scorings: List<PvpLadderScoring> = emptyList()
)