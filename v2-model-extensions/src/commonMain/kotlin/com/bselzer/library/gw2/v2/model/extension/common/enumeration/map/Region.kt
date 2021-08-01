package com.bselzer.library.gw2.v2.model.extension.common.enumeration.map

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Region
{
    @SerialName("Tyria")
    TYRIA,

    @SerialName("Maguuma")
    MAGUUMA,

    @SerialName("Desert")
    DESERT,

    @SerialName("Tundra")
    TUNDRA
}