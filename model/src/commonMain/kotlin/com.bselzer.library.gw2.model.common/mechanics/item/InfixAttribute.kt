package com.bselzer.library.gw2.model.common.mechanics.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfixAttribute(
    @SerialName("attribute")
    val attribute: String = "",

    @SerialName("modifier")
    val modifier: Int = 0
)