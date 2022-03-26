package com.bselzer.gw2.v2.model.armory

import com.bselzer.gw2.v2.model.item.ItemId
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArmoryItem(
    /**
     * The id of the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("id")
    override val id: ItemId = ItemId(),

    /**
     * The maximum amount of this item that can be stored.
     */
    @SerialName("max_count")
    val maxCount: Int = 0
) : Identifiable<Int>