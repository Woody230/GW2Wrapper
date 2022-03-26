package com.bselzer.gw2.v2.model.commerce.price

import com.bselzer.gw2.v2.model.item.ItemId
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Prices(
    /**
     * The id of the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("id")
    override val id: ItemId = ItemId(),

    /**
     * Whether a free to play account can buy or sell this item on the trading post.
     */
    @SerialName("whitelisted")
    val isWhitelisted: Boolean = false,

    @SerialName("buys")
    val buys: Price = Price(),

    @SerialName("sells")
    val sells: Price = Price()
) : Identifiable<Int>