package com.bselzer.gw2.v2.model.enumeration.wvw

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ObjectiveOwner {
    @SerialName("Red")
    RED,

    @SerialName("Blue")
    BLUE,

    @SerialName("Green")
    GREEN,

    @SerialName("Neutral")
    NEUTRAL
}