package com.bselzer.library.gw2.v2.model.extension.common.enumeration.world

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class WorldRegion
{
    @SerialName("1")
    NORTH_AMERICA,

    @SerialName("2")
    EUROPE
}