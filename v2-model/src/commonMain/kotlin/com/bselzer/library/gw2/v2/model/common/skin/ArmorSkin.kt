package com.bselzer.library.gw2.v2.model.common.skin

import com.bselzer.library.gw2.v2.model.common.skin.detail.ArmorSkinDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Armor")
data class ArmorSkin(
    @SerialName("details")
    val details: ArmorSkinDetails = ArmorSkinDetails()
) : Skin()