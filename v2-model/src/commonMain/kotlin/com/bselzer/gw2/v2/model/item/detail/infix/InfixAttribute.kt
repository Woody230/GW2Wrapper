package com.bselzer.gw2.v2.model.item.detail.infix

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfixAttribute(
    @SerialName("attribute")
    val attribute: String = "",

    @SerialName("modifier")
    val modifier: Int = 0
)