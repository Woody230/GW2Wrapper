package com.bselzer.library.gw2.v2.model.common.armory

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArmoryItem(
    /**
     * The id of the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("id")
    val id: Int = 0,

    /**
     * The maximum amount of this item that can be stored.
     */
    @SerialName("max_count")
    val maxCount: Int = 0
)