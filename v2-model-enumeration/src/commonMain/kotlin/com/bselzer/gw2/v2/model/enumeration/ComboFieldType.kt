package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ComboFieldType {
    @SerialName("Air")
    AIR,

    @SerialName("Dark")
    DARK,

    @SerialName("Fire")
    FIRE,

    @SerialName("Ice")
    ICE,

    @SerialName("Light")
    LIGHT,

    @SerialName("Lightning")
    LIGHTNING,

    @SerialName("Poison")
    POISON,

    @SerialName("Smoke")
    SMOKE,

    @SerialName("Ethereal")
    ETHEREAL,

    @SerialName("Water")
    WATER;
}