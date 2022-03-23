package com.bselzer.gw2.v2.model.guild.log

import com.bselzer.gw2.v2.model.item.ItemId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("stash")
data class StashLog(
    /**
     * The type of operation performed on the stash.
     */
    @SerialName("operation")
    val operation: com.bselzer.gw2.v2.model.wrapper.StashOperation = com.bselzer.gw2.v2.model.wrapper.StashOperation(),

    /**
     * The id of the item associated with the operation.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("item_id")
    val itemId: ItemId = ItemId(),

    /**
     * The number of the item with the [itemId] being operated with.
     */
    @SerialName("count")
    val count: Int = 0,

    /**
     * The amount of copper coins operated with.
     */
    @SerialName("coins")
    val coins: Int = 0
) : GuildLog()