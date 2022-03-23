package com.bselzer.gw2.v2.model.item.detail.infix

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfixAttribute(
    @SerialName("attribute")
    val attribute: com.bselzer.gw2.v2.model.wrapper.AttributeName = com.bselzer.gw2.v2.model.wrapper.AttributeName(),

    @SerialName("modifier")
    val modifier: Int = 0
)