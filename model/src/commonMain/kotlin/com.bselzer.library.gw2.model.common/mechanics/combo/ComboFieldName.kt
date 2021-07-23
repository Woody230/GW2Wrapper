package com.bselzer.library.gw2.model.common.mechanics.combo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ComboFieldName
{
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