package com.bselzer.gw2.v2.model.skin.detail

import com.bselzer.gw2.v2.model.value.WeaponDamageType
import com.bselzer.gw2.v2.model.value.WeaponDetailType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeaponSkinDetails(
    @SerialName("type")
    val type: WeaponDetailType = WeaponDetailType(),

    @SerialName("damage_type")
    val damageType: WeaponDamageType = WeaponDamageType()
)