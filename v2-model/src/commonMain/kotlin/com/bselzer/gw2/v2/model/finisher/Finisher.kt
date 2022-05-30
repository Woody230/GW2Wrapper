package com.bselzer.gw2.v2.model.finisher

import com.bselzer.gw2.v2.model.item.ItemId
import com.bselzer.gw2.v2.model.wrapper.ImageLink
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Finisher(
    @SerialName("id")
    override val id: FinisherId = FinisherId(),

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
    val unlockItemIds: List<ItemId> = emptyList(),

    /**
     * The order in which this finisher appears in a list.
     */
    @SerialName("order")
    val order: Int = 0,

    @SerialName("icon")
    val iconLink: ImageLink = ImageLink(),

    @SerialName("name")
    val name: String = ""
) : Identifiable<FinisherId, Int>