package com.bselzer.gw2.v2.model.account.slot

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.item.ItemId
import com.bselzer.gw2.v2.model.skin.SkinId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SharedSlot(
    /**
     * The id of the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("id")
    override val id: ItemId = ItemId(),

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
    val skin: SkinId = SkinId(),

    /**
     * The ids of the upgrades (runes/sigils) applied to the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/Upgrade_component">the wiki</a>
     */
    @SerialName("upgrades")
    val upgrades: List<ItemId> = emptyList(),

    /**
     * The ids of the infusions applied to the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/Infusion">the wiki</a>
     */
    @SerialName("infusions")
    val infusions: List<ItemId> = emptyList(),

    /**
     * What owns this item. Null if there is no binding.
     */
    @SerialName("binding")
    val binding: String? = null
) : Identifiable<Int>