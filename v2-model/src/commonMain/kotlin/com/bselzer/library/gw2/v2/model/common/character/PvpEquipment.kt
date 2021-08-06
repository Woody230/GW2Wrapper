package com.bselzer.library.gw2.v2.model.common.character

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpEquipment(
    /**
     * The id of the PvP amulet.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/amulets">the wiki</a>
     */
    @SerialName("amulet")
    val amulet: Int = 0,

    /**
     * The id of the PvP rune.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("rune")
    val rune: Int = 0,

    /**
     * The ids of the PvP sigils.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("sigils")
    val sigils: List<Int?> = emptyList()
)