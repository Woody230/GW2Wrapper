package com.bselzer.library.gw2.v2.model.common.pvp.season

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpDivisionTier(
    @SerialName("points")
    val points: Int = 0
)