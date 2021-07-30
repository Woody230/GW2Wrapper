package com.bselzer.library.gw2.v2.model.common.mechanics.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemAttribute(
    @SerialName("attribute")
    val name: String = "",

    @SerialName("multiplier")
    val multiplier: Double = 0.0,

    @SerialName("value")
    val value: Int = 0
)