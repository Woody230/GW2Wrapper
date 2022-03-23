package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class EquipmentLocation {
    @SerialName("equipped")
    EQUIPPED,

    @SerialName("Armory")
    LEGENDARY_ARMORY
}