package com.bselzer.gw2.v2.model.enumeration.skin

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ArmorSkinMaterialType {
    @SerialName("cloth")
    CLOTH,

    @SerialName("leather")
    LEATHER,

    @SerialName("metal")
    METAL
}