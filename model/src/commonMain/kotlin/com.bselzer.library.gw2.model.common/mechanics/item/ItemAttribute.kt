package com.bselzer.library.gw2.model.common.mechanics.item

import com.bselzer.library.gw2.model.common.mechanics.profession.AttributeName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemAttribute(
    @SerialName("attribute")
    val name: AttributeName? = null,

    @SerialName("multiplier")
    val multiplier: Double = 0.0,

    @SerialName("value")
    val value: Int = 0
)