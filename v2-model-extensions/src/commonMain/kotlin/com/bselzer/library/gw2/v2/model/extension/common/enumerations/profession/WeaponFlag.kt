package com.bselzer.library.gw2.v2.model.extension.common.enumerations.profession

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class WeaponFlag
{
    @SerialName("Mainhand")
    MAINHAND,

    @SerialName("Offhand")
    OFFHAND,

    @SerialName("TwoHand")
    TWOHAND,

    @SerialName("Aquatic")
    AQUATIC;
}