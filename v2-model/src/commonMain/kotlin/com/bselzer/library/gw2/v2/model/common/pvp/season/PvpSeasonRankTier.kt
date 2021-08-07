package com.bselzer.library.gw2.v2.model.common.pvp.season

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpSeasonRankTier(
    /**
     * The maximum rating to be in the tier.
     */
    @SerialName("rating")
    val maximumRating: Int = 0
)