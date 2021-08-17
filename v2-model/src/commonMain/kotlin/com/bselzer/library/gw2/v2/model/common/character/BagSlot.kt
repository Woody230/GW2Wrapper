package com.bselzer.library.gw2.v2.model.common.character

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BagSlot(
    /**
     * The id of the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The number of this item in the stack.
     */
    @SerialName("count")
    val count: Int = 0,

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
) : Identifiable<Int>