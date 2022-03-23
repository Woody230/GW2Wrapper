package com.bselzer.gw2.v2.model.item.detail.infix

import com.bselzer.gw2.v2.model.value.AttributeName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfixAttribute(
    @SerialName("attribute")
    val attribute: AttributeName = AttributeName(),

    @SerialName("modifier")
    val modifier: Int = 0
)