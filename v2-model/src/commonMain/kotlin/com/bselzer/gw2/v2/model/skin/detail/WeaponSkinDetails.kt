package com.bselzer.gw2.v2.model.skin.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeaponSkinDetails(
    @SerialName("type")
    val type: String = "",

    @SerialName("damage_type")
    val damageType: String = ""
)