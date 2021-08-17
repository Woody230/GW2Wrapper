package com.bselzer.library.gw2.v2.model.common.pvp.hero

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpHeroSkin(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("name")
    val name: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("default")
    val isDefault: Boolean = false,

    /**
     * The ids of the items which unlock the skin.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("unlock_items")
    val unlockItems: List<Int> = emptyList()
) : Identifiable<Int>