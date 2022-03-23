package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class MaterialType {
    @SerialName("cloth")
    CLOTH,

    @SerialName("leather")
    LEATHER,

    @SerialName("metal")
    METAL
}