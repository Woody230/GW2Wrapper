package com.bselzer.library.gw2.v2.model.common.guild.upgrade.cost

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Item")
data class ItemUpgradeCost(
    @SerialName("name")
    val name: String = "",

    /**
     * The id of the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("item_id")
    val itemId: Int = 0
) : GuildUpgradeCost()