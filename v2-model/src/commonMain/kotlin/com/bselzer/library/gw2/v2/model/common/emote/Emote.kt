package com.bselzer.library.gw2.v2.model.common.emote

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Emote(
    /**
     * The name of the emote.
     */
    // TODO enum and extension
    @SerialName("id")
    override val id: String = "",

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
    val unlockItems: List<Int> = emptyList()
) : Identifiable<String>