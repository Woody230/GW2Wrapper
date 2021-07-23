package com.bselzer.library.gw2.model.common.mechanics.item

import com.bselzer.library.gw2.model.common.mechanics.AttributeName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpAmulet(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("attributes")
    val attributes: Map<AttributeName, Int> = emptyMap()
)