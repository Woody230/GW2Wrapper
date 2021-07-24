package com.bselzer.library.gw2.model.common.wvw.match.map.objective

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class MapObjectiveOwner
{
    @SerialName("Red")
    RED,

    @SerialName("Blue")
    BLUE,

    @SerialName("Green")
    GREEN,

    @SerialName("Neutral")
    NEUTRAL
}