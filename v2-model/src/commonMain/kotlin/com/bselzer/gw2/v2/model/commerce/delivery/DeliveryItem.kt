package com.bselzer.gw2.v2.model.commerce.delivery

import com.bselzer.gw2.v2.model.item.ItemId
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DeliveryItem(
    /**
     * The id of the item ready for pickup.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("id")
    override val id: ItemId = ItemId(),

    /**
     * The number of the item with [id] ready for pickup.
     */
    @SerialName("count")
    val count: Int = 0
) : Identifiable<Int>