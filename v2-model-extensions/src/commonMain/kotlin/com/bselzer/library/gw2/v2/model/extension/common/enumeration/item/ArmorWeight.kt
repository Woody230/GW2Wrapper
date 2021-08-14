package com.bselzer.library.gw2.v2.model.extension.common.enumeration.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ArmorWeight
{
    @SerialName("Heavy")
    HEAVY,

    @SerialName("Medium")
    MEDIUM,

    @SerialName("Light")
    LIGHT,

    @SerialName("Clothing")
    CLOTHING
}