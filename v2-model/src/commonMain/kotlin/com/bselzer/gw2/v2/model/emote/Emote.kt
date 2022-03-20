package com.bselzer.gw2.v2.model.emote

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.item.ItemId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Emote(
    /**
     * The name of the emote.
     */
    @SerialName("id")
    override val id: EmoteId = EmoteId(),

    /**
     * The unlocked commands associated with the emote.
     */
    @SerialName("commands")
    val commands: List<String> = emptyList(),

    /**
     * The items required to unlock this emote.
     * @see <a href="https://wiki.guildwars2.com/wiki/Item">the wiki</a>
     */
    @SerialName("unlock_items")
    val unlockItems: List<ItemId> = emptyList()
) : Identifiable<String>