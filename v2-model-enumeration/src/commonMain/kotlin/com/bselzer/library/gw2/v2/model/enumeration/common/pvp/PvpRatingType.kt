package com.bselzer.library.gw2.v2.model.enumeration.common.pvp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class PvpRatingType
{
    @SerialName("Ranked")
    RANKED,

    @SerialName("Unranked")
    UNRANKED,

    @SerialName("2v2Ranked")
    TWO_VS_TWO_RANKED,

    /**
     * For custom arenas.
     */
    @SerialName("None")
    NONE
}