package com.bselzer.library.gw2.v2.model.common.pvp.season.leaderboard

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpLadderSettings(
    @SerialName("name")
    val name: String = "",

    @SerialName("duration")
    val duration: Int = 0,

    /**
     * The id of the scoring method in the form of a UUID.
     */
    @SerialName("scoring")
    val scoring: String = "",

    @SerialName("tiers")
    val tiers: List<PvpLadderSettingsTier> = emptyList()
)