package com.bselzer.library.gw2.v2.model.common.guild.treasury

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildTreasurySlot(
    /**
     * The id of the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("item_id")
    val itemId: Int = 0,

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