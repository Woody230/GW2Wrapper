package com.bselzer.library.gw2.v2.model.enumeration.common.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class WeaponDamageType
{
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