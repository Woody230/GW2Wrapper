package com.bselzer.library.gw2.v2.model.common.account.equipment

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// TODO replace with PvpEquipment in character?
@Serializable
data class EquipmentTemplatePvp(
    /**
     * The id of the PvP amulet.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/amulets">the wiki</a>
     */
    @SerialName("amulet")
    val amuletId: Int = 0,

    /**
     * The id of the PvP rune.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("rune")
    val runeId: Int = 0,

    /**
     * The ids of the PvP sigils. An id is null if it is not selected.
     *
     * Order: primary weapon sigil 1, secondary weapon sigil 1, primary weapon sigil 2, secondary weapon sigil 2
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("sigils")
    val sigilIds: List<Int> = emptyList()
)