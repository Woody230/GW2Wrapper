package com.bselzer.gw2.v2.model.achievement.bit

import com.bselzer.gw2.v2.model.item.ItemId
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Item")
data class ItemBit(
    /**
     * The id of the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("id")
    override val id: ItemId = ItemId()
) : AchievementBit(), Identifiable<ItemId, Int>