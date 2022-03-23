package com.bselzer.gw2.v2.model.skin.detail

import com.bselzer.gw2.v2.model.enumeration.wrapper.ArmorDetailType
import com.bselzer.gw2.v2.model.enumeration.wrapper.ArmorWeight
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArmorSkinDetails(
    @SerialName("type")
    val type: ArmorDetailType = ArmorDetailType(),

    @SerialName("weight_class")
    val weightClass: ArmorWeight = ArmorWeight(),

    @SerialName("dye_slots")
    val dyeSlots: ArmorSkinDyeSlots = ArmorSkinDyeSlots()
)