package com.bselzer.gw2.v2.model.item.detail

import com.bselzer.gw2.v2.model.enumeration.wrapper.ArmorDetailType
import com.bselzer.gw2.v2.model.enumeration.wrapper.ArmorWeight
import com.bselzer.gw2.v2.model.item.ItemId
import com.bselzer.gw2.v2.model.item.detail.infix.InfixUpgrade
import com.bselzer.gw2.v2.model.item.detail.infusion.InfusionSlot
import com.bselzer.gw2.v2.model.itemstat.ItemStatId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArmorDetails(
    @SerialName("type")
    val type: ArmorDetailType = ArmorDetailType(),

    @SerialName("weight_class")
    val weightClass: ArmorWeight = ArmorWeight(),

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
    val suffixItemId: ItemId = ItemId(),

    /**
     * The id of the secondary suffix item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("secondary_suffix_item_id")
    val secondarySuffixItemId: ItemId = ItemId(),

    /**
     * The ids of the selectable stats.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">the wiki</a>
     */
    @SerialName("stat_choices")
    val statChoices: List<ItemStatId> = emptyList()
)