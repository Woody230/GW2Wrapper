package com.bselzer.gw2.v2.model.enumeration.pvp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class PvpResult {
    @SerialName("Victory")
    VICTORY,

    @SerialName("Defeat")
    DEFEAT
}