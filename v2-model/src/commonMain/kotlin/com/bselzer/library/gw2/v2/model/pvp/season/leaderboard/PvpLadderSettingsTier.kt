package com.bselzer.library.gw2.v2.model.pvp.season.leaderboard

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpLadderSettingsTier(
    /**
     * A collection of a maximum number followed by a minimum number.
     */
    @SerialName("range")
    val range: List<Int> = emptyList()
)