package com.bselzer.library.gw2.v2.model.account

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SharedSlot(
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
     * The number of charges left.
     * If charges exist, then there can only be a single item because chargeable items do not stack.
     */
    @SerialName("charges")
    val charges: Int = 0,

    /**
     * The id of the skin, if applicable.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skins">the wiki</a>
     */
    @SerialName("skin")
    val skin: Int = 0,

    /**
     * The ids of the upgrades (runes/sigils) applied to the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/Upgrade_component">the wiki</a>
     */
    @SerialName("upgrades")
    val upgrades: List<Int> = emptyList(),

    /**
     * The ids of the infusions applied to the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/Infusion">the wiki</a>
     */
    @SerialName("infusions")
    val infusions: List<Int> = emptyList(),

    /**
     * What owns this item. Null if there is no binding.
     */
    @SerialName("binding")
    val binding: String? = null
) : Identifiable<Int>