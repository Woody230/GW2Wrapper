package com.bselzer.library.gw2.v2.model.common.character

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Bag(
    /**
     * The id of the bag item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The number of slots in the bag.
     */
    @SerialName("size")
    val count: Int = 0,

    /**
     * The bag slots. A null [BagSlot] indicates that there is no item in the slot.
     */
    @SerialName("inventory")
    val slots: List<BagSlot?> = emptyList()
) : Identifiable<Int>