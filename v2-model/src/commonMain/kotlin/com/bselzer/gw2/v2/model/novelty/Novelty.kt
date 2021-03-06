package com.bselzer.gw2.v2.model.novelty

import com.bselzer.gw2.v2.model.enumeration.wrapper.NoveltySlot
import com.bselzer.gw2.v2.model.item.ItemId
import com.bselzer.gw2.v2.model.wrapper.ImageLink
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Novelty(
    @SerialName("id")
    override val id: NoveltyId = NoveltyId(),

    /**
     * The ids of the items used to unlock this novelty.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("unlock_item")
    val unlockItemIds: List<ItemId> = emptyList(),

    @SerialName("description")
    val description: String = "",

    @SerialName("icon")
    val iconLink: ImageLink = ImageLink(),

    @SerialName("name")
    val name: String = "",

    @SerialName("slot")
    val slot: NoveltySlot = NoveltySlot()
) : Identifiable<NoveltyId, Int>