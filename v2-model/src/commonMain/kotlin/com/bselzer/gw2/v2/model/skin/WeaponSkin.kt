package com.bselzer.gw2.v2.model.skin

import com.bselzer.gw2.v2.model.skin.detail.WeaponSkinDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Weapon")
data class WeaponSkin(
    @SerialName("details")
    val details: WeaponSkinDetails = WeaponSkinDetails()
) : Skin()