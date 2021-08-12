package com.bselzer.library.gw2.v2.model.common.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfixUpgrade(
    @SerialName("id")
    val itemStatId: Int = 0,

    @SerialName("attributes")
    val attributes: List<InfixAttribute> = emptyList(),

    @SerialName("buff")
    val buff: InfixBuff = InfixBuff()
)
