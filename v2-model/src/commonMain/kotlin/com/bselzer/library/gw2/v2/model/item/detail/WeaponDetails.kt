package com.bselzer.library.gw2.v2.model.item.detail

import com.bselzer.library.gw2.v2.model.item.detail.infix.InfixUpgrade
import com.bselzer.library.gw2.v2.model.item.detail.infusion.InfusionSlot
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeaponDetails(
    @SerialName("type")
    val type: String = "",

    @SerialName("damage_type")
    val damageType: String = "",

    @SerialName("min_power")
    val minPower: Int = 0,

    @SerialName("max_power")
    val maxPower: Int = 0,

    @SerialName("defense")
    val defense: Int = 0,

    @SerialName("infusion_slots")
    val infusionSlots: List<InfusionSlot> = emptyList(),

    /**
     * The adjustment to combine with the item stat attribute.
     */
    @SerialName("attribute_adjustment")
    val attributeAdjustment: Double = 0.0,

    @SerialName("infix_upgrade")
    val infixUpgrade: InfixUpgrade = InfixUpgrade(),

    /**
     * The id of the suffix item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("suffix_item_id")
    val suffixItemId: Int = 0,

    /**
     * The id of the secondary suffix item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("secondary_suffix_item_id")
    val secondarySuffixItemId: Int = 0,

    /**
     * The ids of the selectable stats.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">the wiki</a>
     */
    @SerialName("stat_choices")
    val statChoices: List<Int> = emptyList()
)