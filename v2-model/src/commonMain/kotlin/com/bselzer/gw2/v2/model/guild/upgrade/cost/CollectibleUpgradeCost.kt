package com.bselzer.gw2.v2.model.guild.upgrade.cost

import com.bselzer.gw2.v2.model.item.ItemId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Collectible")
data class CollectibleUpgradeCost(
    @SerialName("name")
    val name: String = "",

    /**
     * The id of the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("item_id")
    val itemId: ItemId = ItemId()
) : GuildUpgradeCost()