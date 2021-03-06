package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class AttunementName {
    @SerialName("Fire")
    FIRE,

    @SerialName("Water")
    WATER,

    @SerialName("Earth")
    EARTH,

    @SerialName("Air")
    AIR;
}