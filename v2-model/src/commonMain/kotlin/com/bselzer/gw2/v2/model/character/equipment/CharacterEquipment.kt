package com.bselzer.gw2.v2.model.character.equipment

import com.bselzer.gw2.v2.model.character.CharacterName
import com.bselzer.gw2.v2.model.color.DyeColorId
import com.bselzer.gw2.v2.model.enumeration.wrapper.Binding
import com.bselzer.gw2.v2.model.enumeration.wrapper.EquipmentSlot
import com.bselzer.gw2.v2.model.item.ItemId
import com.bselzer.gw2.v2.model.skin.SkinId
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterEquipment(
    /**
     * The id of the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("id")
    override val id: ItemId = ItemId(),

    /**
     * The type of slot.
     */
    @SerialName("slot")
    val slot: EquipmentSlot = EquipmentSlot(),

    /**
     * The ids of the equipped infusions.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("infusions")
    val infusions: List<ItemId> = emptyList(),

    /**
     * The ids of the equipped upgrade components.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("upgrades")
    val upgrades: List<ItemId> = emptyList(),

    /**
     * The id of the equipped skin.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skins">the wiki</a>
     */
    @SerialName("skin")
    val skin: SkinId = SkinId(),

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
    val binding: Binding? = null,

    /**
     * The number of charges left.
     */
    @SerialName("charges")
    val charges: Int = 0,

    /**
     * Who owns this item. Null if the binding is NOT for a character.
     */
    @SerialName("bound_to")
    val boundTo: CharacterName? = null,

    /**
     * The ids of the dyes. An id will be null if there is no selection.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    @SerialName("dyes")
    val dyes: List<DyeColorId?> = emptyList()
) : Identifiable<Int>