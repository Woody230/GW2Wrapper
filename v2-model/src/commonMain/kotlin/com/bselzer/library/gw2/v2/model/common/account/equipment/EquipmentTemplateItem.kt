package com.bselzer.library.gw2.v2.model.common.account.equipment

import com.bselzer.library.gw2.v2.model.common.character.CharacterItemStat
import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EquipmentTemplateItem(
    /**
     * The id of the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The type of slot.
     */
    @SerialName("slot")
    val slot: String = "",

    /**
     * The ids of the equipped infusions.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("infusions")
    val infusions: List<Int> = emptyList(),

    /**
     * The ids of the equipped upgrade components.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("upgrades")
    val upgrades: List<Int> = emptyList(),

    /**
     * The id of the equipped skin.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skins">the wiki</a>
     */
    @SerialName("skin")
    val skin: Int = 0,

    /**
     * The stats of the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">the wiki</a>
     */
    @SerialName("stats")
    val stats: List<CharacterItemStat> = emptyList(),

    /**
     * What owns this item. Null if there is no binding.
     */
    @SerialName("binding")
    val binding: String? = null,

    /**
     * Who owns this item. Null if the binding is NOT for a character.
     */
    @SerialName("bound_to")
    val boundTo: String? = null,

    /**
     * Where the item is stored.
     */
    @SerialName("location")
    val location: String = "",

    /**
     * The ids of the dyes. An id will be null if there is no selection.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    @SerialName("dyes")
    val dyes: List<Int?> = emptyList()
) : Identifiable<Int>