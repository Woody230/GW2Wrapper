package com.bselzer.library.gw2.v2.model.mini

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Mini(
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The id of the item used to unlock this mail carrier.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("item_id")
    val unlockItemId: Int = 0,

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
    val iconLink: String = "",

    @SerialName("name")
    val name: String = "",
) : Identifiable<Int>