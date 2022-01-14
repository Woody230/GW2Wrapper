package com.bselzer.gw2.v2.model.enumeration.continent

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class RegionName {
    @SerialName("Tyria")
    TYRIA,

    @SerialName("Maguuma")
    MAGUUMA,

    @SerialName("Desert")
    DESERT,

    @SerialName("Tundra")
    TUNDRA
}