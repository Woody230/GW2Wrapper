package com.bselzer.gw2.v2.model.skin

import com.bselzer.gw2.v2.model.skin.detail.ArmorSkinDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Armor")
data class ArmorSkin(
    @SerialName("details")
    val details: ArmorSkinDetails = ArmorSkinDetails()
) : Skin()