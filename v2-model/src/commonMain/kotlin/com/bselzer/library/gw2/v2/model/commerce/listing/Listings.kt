package com.bselzer.library.gw2.v2.model.commerce.listing

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Listings(
    /**
     * The id of the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("id")
    override val id: Int = 0,

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