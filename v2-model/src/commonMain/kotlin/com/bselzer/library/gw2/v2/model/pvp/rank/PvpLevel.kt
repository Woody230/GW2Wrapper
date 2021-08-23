package com.bselzer.library.gw2.v2.model.pvp.rank

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpLevel(
    /**
     * The minimum PvP level to be at this rank.
     */
    @SerialName("min_rank")
    val minRank: Int = 0,

    /**
     * The maximum PvP level to be at this rank.
     */
    @SerialName("max_rank")
    val maxRank: Int = 0,

    /**
     * The amount of experience required to go from the [minRank] to the [maxRank]
     */
    @SerialName("points")
    val points: Int = 0
)