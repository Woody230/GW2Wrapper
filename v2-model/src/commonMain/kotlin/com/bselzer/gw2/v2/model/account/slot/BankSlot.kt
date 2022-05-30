package com.bselzer.gw2.v2.model.account.slot

import com.bselzer.gw2.v2.model.character.CharacterName
import com.bselzer.gw2.v2.model.character.equipment.CharacterItemStat
import com.bselzer.gw2.v2.model.color.DyeColorId
import com.bselzer.gw2.v2.model.enumeration.wrapper.Binding
import com.bselzer.gw2.v2.model.item.ItemId
import com.bselzer.gw2.v2.model.skin.SkinId
import com.bselzer.gw2.v2.scope.core.Permission
import com.bselzer.gw2.v2.scope.core.Requirement
import com.bselzer.gw2.v2.scope.core.Scope
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The account vault information.
 *
 * @see <a href="https://wiki.guildwars2.com/wiki/Account_vault">the wiki</a>
 */
@Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.INVENTORIES)
@Serializable
data class BankSlot(
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
     * The ids of the dyes. An id will be null if there is no selection.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    @SerialName("dyes")
    val dyes: List<DyeColorId?> = emptyList(),

    /**
     * The ids of the upgrades (runes/sigils) applied to the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/Upgrade_component">the wiki</a>
     */
    @SerialName("upgrades")
    val upgrades: List<ItemId> = emptyList(),

    /**
     * The position of the upgrades applied to the item.
     */
    @SerialName("upgrade_slot_indices")
    val upgradeSlots: List<Int> = emptyList(),

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
    val binding: Binding? = null,

    /**
     * Who owns this item. Null if the binding is NOT for a character.
     */
    @SerialName("bound_to")
    val boundTo: CharacterName? = null,

    /**
     * The stats of the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">the wiki</a>
     */
    @SerialName("stats")
    val stats: List<CharacterItemStat> = emptyList()
) : Identifiable<ItemId, Int>