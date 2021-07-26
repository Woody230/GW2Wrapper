package com.bselzer.library.gw2.model.extension.common.enumerations.wvw

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ObjectiveOwner
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