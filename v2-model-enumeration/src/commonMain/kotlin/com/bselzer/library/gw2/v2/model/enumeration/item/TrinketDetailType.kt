package com.bselzer.library.gw2.v2.model.enumeration.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class TrinketDetailType
{
    @SerialName("Accessory")
    ACCESSORY,

    @SerialName("Amulet")
    AMULET,

    @SerialName("Ring")
    RING,
}