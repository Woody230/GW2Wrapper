package com.bselzer.gw2.v2.model.item.detail.infusion

import com.bselzer.gw2.v2.model.enumeration.wrapper.InfusionUpgradeFlag
import com.bselzer.gw2.v2.model.item.ItemId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfusionSlot(
    @SerialName("flags")
    val flags: List<InfusionUpgradeFlag> = emptyList(),

    /**
     * The id of the infusion item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("item_id")
    val itemId: ItemId = ItemId()
)