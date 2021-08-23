package com.bselzer.library.gw2.v2.model.skin.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArmorSkinDetails(
    @SerialName("type")
    val type: String = "",

    @SerialName("weight_class")
    val weightClass: String = "",

    @SerialName("dye_slots")
    val dyeSlots: ArmorSkinDyeSlots = ArmorSkinDyeSlots()
)