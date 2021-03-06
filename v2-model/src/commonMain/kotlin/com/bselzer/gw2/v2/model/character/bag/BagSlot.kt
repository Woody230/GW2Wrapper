package com.bselzer.gw2.v2.model.character.bag

import com.bselzer.gw2.v2.model.character.CharacterName
import com.bselzer.gw2.v2.model.character.equipment.CharacterItemStat
import com.bselzer.gw2.v2.model.enumeration.wrapper.Binding
import com.bselzer.gw2.v2.model.item.ItemId
import com.bselzer.gw2.v2.model.skin.SkinId
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BagSlot(
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
     * Who owns this item. Null if the binding is NOT for a character.
     */
    @SerialName("bound_to")
    val boundTo: CharacterName? = null,
) : Identifiable<ItemId, Int>