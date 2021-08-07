package com.bselzer.library.gw2.v2.model.extension.common.enumeration.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ItemLocation
{
    @SerialName("equipped")
    EQUIPPED,

    @SerialName("Armory")
    LEGENDARY_ARMORY
}