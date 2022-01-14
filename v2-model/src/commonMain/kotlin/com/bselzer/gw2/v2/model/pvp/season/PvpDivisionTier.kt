package com.bselzer.gw2.v2.model.pvp.season

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpDivisionTier(
    @SerialName("points")
    val points: Int = 0
)