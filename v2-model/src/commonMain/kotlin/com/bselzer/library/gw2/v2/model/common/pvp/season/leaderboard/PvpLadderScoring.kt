package com.bselzer.library.gw2.v2.model.common.pvp.season.leaderboard

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpLadderScoring(
    /**
     * The id of the scoring method in the form of a UUID.
     */
    @SerialName("id")
    val id: String = "",

    /**
     * The type of the content.
     */
    @SerialName("type")
    val type: String = "",

    /**
     * The description of the scoring method.
     */
    @SerialName("description")
    val description: String = "",

    /**
     * The type of scoring method.
     */
    @SerialName("name")
    val name: String = "",

    /**
     * The type of order priority.
     */
    @SerialName("ordering")
    val ordering: String = ""
)