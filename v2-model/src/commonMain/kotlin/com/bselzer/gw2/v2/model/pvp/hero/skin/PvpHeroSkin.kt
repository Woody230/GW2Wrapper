package com.bselzer.gw2.v2.model.pvp.hero.skin

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.item.ItemId
import com.bselzer.gw2.v2.model.wrapper.ImageLink
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpHeroSkin(
    @SerialName("id")
    override val id: PvpHeroSkinId = PvpHeroSkinId(),

    @SerialName("name")
    val name: String = "",

    @SerialName("icon")
    val iconLink: ImageLink = ImageLink(),

    @SerialName("default")
    val isDefault: Boolean = false,

    /**
     * The ids of the items which unlock the skin.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("unlock_items")
    val unlockItems: List<ItemId> = emptyList()
) : Identifiable<Int>