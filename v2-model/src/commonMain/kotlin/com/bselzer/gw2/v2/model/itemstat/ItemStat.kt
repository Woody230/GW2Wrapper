package com.bselzer.gw2.v2.model.itemstat

import com.bselzer.gw2.v2.model.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemStat(
    @SerialName("id")
    override val id: ItemStatId = ItemStatId(),

    @SerialName("name")
    val name: String = "",

    @SerialName("attributes")
    val attributes: List<ItemAttribute> = emptyList()
) : Identifiable<Int>