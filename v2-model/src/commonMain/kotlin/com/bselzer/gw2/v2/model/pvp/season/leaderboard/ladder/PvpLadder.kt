package com.bselzer.gw2.v2.model.pvp.season.leaderboard.ladder

import com.bselzer.gw2.v2.model.pvp.season.leaderboard.ladder.score.PvpLadderScoring
import com.bselzer.gw2.v2.model.pvp.season.leaderboard.ladder.settings.PvpLadderSettings
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpLadder(
    @SerialName("settings")
    val settings: PvpLadderSettings = PvpLadderSettings(),

    @SerialName("scorings")
    val scorings: List<PvpLadderScoring> = emptyList()
)