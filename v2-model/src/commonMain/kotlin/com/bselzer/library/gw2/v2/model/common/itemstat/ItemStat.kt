package com.bselzer.library.gw2.v2.model.common.itemstat

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemStat(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String = "",

    @SerialName("attributes")
    val attributes: List<ItemAttribute> = emptyList()
)