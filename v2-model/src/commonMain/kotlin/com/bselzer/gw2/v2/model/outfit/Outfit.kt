package com.bselzer.gw2.v2.model.outfit

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.item.ItemId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Outfit(
    @SerialName("id")
    override val id: OutfitId = OutfitId(),

    /**
     * The ids of the items used to unlock this outfit.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("unlock_items")
    val unlockItemIds: List<ItemId> = emptyList(),

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("name")
    val name: String = ""
) : Identifiable<Int>