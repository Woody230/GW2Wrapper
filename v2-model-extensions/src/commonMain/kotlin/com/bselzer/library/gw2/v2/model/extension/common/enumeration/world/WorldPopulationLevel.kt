package com.bselzer.library.gw2.v2.model.extension.common.enumeration.world

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class WorldPopulationLevel
{
    @SerialName("Low")
    LOW,

    @SerialName("Medium")
    MEDIUM,

    @SerialName("High")
    HIGH,

    @SerialName("VeryHigh")
    VERY_HIGH,

    @SerialName("Full")
    FULL,
}