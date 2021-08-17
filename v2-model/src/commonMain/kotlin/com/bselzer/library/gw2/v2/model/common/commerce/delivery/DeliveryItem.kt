package com.bselzer.library.gw2.v2.model.common.commerce.delivery

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DeliveryItem(
    /**
     * The id of the item ready for pickup.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The number of the item with [id] ready for pickup.
     */
    @SerialName("count")
    val count: Int = 0
) : Identifiable<Int>