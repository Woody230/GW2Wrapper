package com.bselzer.gw2.v2.model.guild.treasury

import com.bselzer.gw2.v2.model.item.ItemId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildTreasurySlot(
    /**
     * The id of the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("item_id")
    val itemId: ItemId = ItemId(),

    /**
     * The number of the item in the stack.
     */
    @SerialName("count")
    val count: Int = 0,

    /**
     * The guild upgrades that need the item.
     */
    @SerialName("needed_by")
    val neededBy: List<TreasuryUpgrade> = emptyList()
)