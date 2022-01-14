package com.bselzer.gw2.v2.model.guild.log

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("stash")
data class StashLog(
    /**
     * The type of operation performed on the stash.
     */
    @SerialName("operation")
    val operation: String = "",

    /**
     * The id of the item associated with the operation.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("item_id")
    val itemId: Int = 0,

    /**
     * The number of the item with the [itemId] being operated with.
     */
    @SerialName("count")
    val count: Int = 0,

    /**
     * The amount of copper coins operated with.
     */
    @SerialName("coins")
    val coins: Int = 0
) : GuildLog()