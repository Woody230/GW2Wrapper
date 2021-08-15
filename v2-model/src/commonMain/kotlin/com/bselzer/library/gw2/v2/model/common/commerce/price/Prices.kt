package com.bselzer.library.gw2.v2.model.common.commerce.price

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Prices(
    /**
     * The id of the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("id")
    val id: Int = 0,

    /**
     * Whether a free to play account can buy or sell this item on the trading post.
     */
    @SerialName("whitelisted")
    val isWhitelisted: Boolean = false,

    @SerialName("buys")
    val buys: Price = Price(),

    @SerialName("sells")
    val sells: Price = Price()
)