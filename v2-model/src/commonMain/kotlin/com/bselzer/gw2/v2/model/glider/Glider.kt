package com.bselzer.gw2.v2.model.glider

import com.bselzer.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Glider(
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The ids of the items used to unlock this glider.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("unlock_items")
    val unlockItemIds: List<Int> = emptyList(),

    /**
     * The order in which this glider appears in a list.
     */
    @SerialName("order")
    val order: Int = 0,

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    /**
     * The ids of the default dye colors.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    @SerialName("default_dyes")
    val defaultDyeIds: List<Int> = emptyList()
) : Identifiable<Int>