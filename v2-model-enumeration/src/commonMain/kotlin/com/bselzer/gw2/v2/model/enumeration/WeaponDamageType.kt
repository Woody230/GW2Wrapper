package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class WeaponDamageType {
    @SerialName("Fire")
    FIRE,

    @SerialName("Ice")
    ICE,

    @SerialName("Lightning")
    LIGHTNING,

    @SerialName("Physical")
    PHYSICAL,

    @SerialName("Choking")
    CHOKING
}