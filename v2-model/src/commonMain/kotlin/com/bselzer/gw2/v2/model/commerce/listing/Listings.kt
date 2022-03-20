package com.bselzer.gw2.v2.model.commerce.listing

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.item.ItemId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Listings(
    /**
     * The id of the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("id")
    override val id: ItemId = ItemId(),

    /**
     * The buy listings ordered from the lowest to the highest buy order.
     */
    @SerialName("buys")
    val buys: List<Listing> = emptyList(),

    /**
     * The sell listings ordered from the lowest to the highest sell offer.
     */
    @SerialName("sells")
    val sells: List<Listing> = emptyList()
) : Identifiable<Int>