package com.bselzer.gw2.v2.model.pvp.season.leaderboard.ladder.score

import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpLadderScoring(
    /**
     * The id of the scoring method in the form of a UUID.
     */
    @SerialName("id")
    override val id: PvpScoringId = PvpScoringId(),

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
) : Identifiable<PvpScoringId, String>