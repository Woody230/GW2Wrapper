package com.bselzer.library.gw2.model.common.item.detail.infix

import com.bselzer.library.gw2.model.common.AttributeName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfixAttribute(
    @SerialName("attribute")
    val attribute: AttributeName? = null,

    @SerialName("modifier")
    val modifier: Int = 0
)