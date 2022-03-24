package com.bselzer.gw2.v2.model.glider

import com.bselzer.gw2.v2.model.color.DyeColorId
import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.item.ItemId
import com.bselzer.gw2.v2.model.wrapper.ImageLink
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Glider(
    @SerialName("id")
    override val id: GliderId = GliderId(),

    /**
     * The ids of the items used to unlock this glider.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("unlock_items")
    val unlockItemIds: List<ItemId> = emptyList(),

    /**
     * The order in which this glider appears in a list.
     */
    @SerialName("order")
    val order: Int = 0,

    @SerialName("icon")
    val iconLink: ImageLink = ImageLink(),

    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    /**
     * The ids of the default dye colors.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    @SerialName("default_dyes")
    val defaultDyeIds: List<DyeColorId> = emptyList()
) : Identifiable<Int>