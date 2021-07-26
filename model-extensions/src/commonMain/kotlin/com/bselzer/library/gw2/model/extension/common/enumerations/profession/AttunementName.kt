package com.bselzer.library.gw2.model.extension.common.enumerations.profession

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class AttunementName
{
    @SerialName("Fire")
    FIRE,

    @SerialName("Water")
    WATER,

    @SerialName("Earth")
    EARTH,

    @SerialName("Air")
    AIR;
}