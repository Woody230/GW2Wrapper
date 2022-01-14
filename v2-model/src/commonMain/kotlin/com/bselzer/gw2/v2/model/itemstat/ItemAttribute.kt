package com.bselzer.gw2.v2.model.itemstat

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