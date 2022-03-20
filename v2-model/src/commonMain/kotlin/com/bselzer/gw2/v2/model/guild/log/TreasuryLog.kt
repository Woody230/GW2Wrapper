package com.bselzer.gw2.v2.model.guild.log

import com.bselzer.gw2.v2.model.item.ItemId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("treasury")
data class TreasuryLog(
    /**
     * The id of the item being deposited.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("item_id")
    val itemId: ItemId = ItemId(),

    /**
     * The number of the item with the [itemId] being deposited.
     */
    @SerialName("count")
    val count: Int = 0
) : GuildLog()