package com.bselzer.library.gw2.v2.model.common.finisher

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Finisher(
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The description of how to unlock this finisher.
     */
    @SerialName("unlock_details")
    val unlockDescription: String = "",

    /**
     * The ids of the items used to unlock this finisher.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("unlock_items")
    val unlockItemIds: List<Int> = emptyList(),

    /**
     * The order in which this finisher appears in a list.
     */
    @SerialName("order")
    val order: Int = 0,

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("name")
    val name: String = ""
) : Identifiable<Int>