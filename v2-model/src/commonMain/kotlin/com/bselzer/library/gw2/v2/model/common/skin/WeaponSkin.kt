package com.bselzer.library.gw2.v2.model.common.skin

import com.bselzer.library.gw2.v2.model.common.skin.detail.WeaponSkinDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Weapon")
data class WeaponSkin(
    @SerialName("details")
    val details: WeaponSkinDetails = WeaponSkinDetails()
) : Skin()