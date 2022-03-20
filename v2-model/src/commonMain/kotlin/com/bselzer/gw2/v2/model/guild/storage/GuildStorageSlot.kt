package com.bselzer.gw2.v2.model.guild.storage

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.item.ItemId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildStorageSlot(
    /**
     * The id of the consumable.
     */
    @SerialName("id")
    override val id: ItemId = ItemId(),

    /**
     * The number of the consumable in the stack.
     */
    @SerialName("count")
    val count: Int = 0
) : Identifiable<Int>