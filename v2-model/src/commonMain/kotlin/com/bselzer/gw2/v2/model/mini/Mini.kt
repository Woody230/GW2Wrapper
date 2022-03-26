package com.bselzer.gw2.v2.model.mini

import com.bselzer.gw2.v2.model.item.ItemId
import com.bselzer.gw2.v2.model.wrapper.ImageLink
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Mini(
    @SerialName("id")
    override val id: MiniId = MiniId(),

    /**
     * The id of the item used to unlock this mail carrier.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("item_id")
    val unlockItemId: ItemId = ItemId(),

    /**
     * The description of how to unlock this mini.
     */
    @SerialName("unlock")
    val unlockDescription: String = "",

    /**
     * The order in which this glider appears in a list.
     */
    @SerialName("order")
    val order: Int = 0,

    @SerialName("icon")
    val iconLink: ImageLink = ImageLink(),

    @SerialName("name")
    val name: String = "",
) : Identifiable<Int>