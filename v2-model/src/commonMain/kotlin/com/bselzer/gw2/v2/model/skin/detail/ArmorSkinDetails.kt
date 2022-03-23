package com.bselzer.gw2.v2.model.skin.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArmorSkinDetails(
    @SerialName("type")
    val type: com.bselzer.gw2.v2.model.wrapper.ArmorDetailType = com.bselzer.gw2.v2.model.wrapper.ArmorDetailType(),

    @SerialName("weight_class")
    val weightClass: com.bselzer.gw2.v2.model.wrapper.ArmorWeight = com.bselzer.gw2.v2.model.wrapper.ArmorWeight(),

    @SerialName("dye_slots")
    val dyeSlots: ArmorSkinDyeSlots = ArmorSkinDyeSlots()
)