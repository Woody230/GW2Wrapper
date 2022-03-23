package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class WeaponFlag {
    @SerialName("Mainhand")
    MAINHAND,

    @SerialName("Offhand")
    OFFHAND,

    @SerialName("TwoHand")
    TWOHAND,

    @SerialName("Aquatic")
    AQUATIC;
}