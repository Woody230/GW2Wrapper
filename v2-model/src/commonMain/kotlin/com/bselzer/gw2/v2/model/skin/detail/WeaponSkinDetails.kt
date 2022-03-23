package com.bselzer.gw2.v2.model.skin.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeaponSkinDetails(
    @SerialName("type")
    val type: com.bselzer.gw2.v2.model.wrapper.WeaponDetailType = com.bselzer.gw2.v2.model.wrapper.WeaponDetailType(),

    @SerialName("damage_type")
    val damageType: com.bselzer.gw2.v2.model.wrapper.WeaponDamageType = com.bselzer.gw2.v2.model.wrapper.WeaponDamageType()
)