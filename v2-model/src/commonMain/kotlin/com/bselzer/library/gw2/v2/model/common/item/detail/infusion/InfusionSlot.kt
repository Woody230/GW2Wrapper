package com.bselzer.library.gw2.v2.model.common.item.detail.infusion

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfusionSlot(
    @SerialName("flags")
    val flags: List<String> = emptyList(),

    /**
     * The id of the infusion item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("item_id")
    val itemId: Int = 0
)