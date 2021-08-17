package com.bselzer.library.gw2.v2.model.common.novelty

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Novelty(
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The ids of the items used to unlock this novelty.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("unlock_item")
    val unlockItemIds: List<Int> = emptyList(),

    @SerialName("description")
    val description: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("name")
    val name: String = "",

    @SerialName("slot")
    val slot: String = ""
) : Identifiable<Int>