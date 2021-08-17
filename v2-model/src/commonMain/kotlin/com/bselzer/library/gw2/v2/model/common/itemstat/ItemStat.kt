package com.bselzer.library.gw2.v2.model.common.itemstat

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemStat(
    @SerialName("id")
    override val id: Int,

    @SerialName("name")
    val name: String = "",

    @SerialName("attributes")
    val attributes: List<ItemAttribute> = emptyList()
) : Identifiable<Int>