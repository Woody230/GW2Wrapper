package com.bselzer.library.gw2.v2.model.common.account.bank

import com.bselzer.library.gw2.v2.annotation.common.scope.Permission
import com.bselzer.library.gw2.v2.annotation.common.scope.Requirement
import com.bselzer.library.gw2.v2.annotation.common.scope.Scope
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
    @SerialName("id")
    val id: Int = 0,

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
     * The ids of the dyes, if applicable.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    @SerialName("dyes")
    val dyes: List<Int> = emptyList(),

    /**
     * The ids of the upgrades (runes/sigils) applied to the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/Upgrade_component">the wiki</a>
     */
    @SerialName("upgrades")
    val upgrades: List<Int> = emptyList(),

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
    val infusions: List<Int> = emptyList(),

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
     * The stats of the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">the wiki</a>
     */
    @SerialName("stats")
    val stats: List<BankItemStat> = emptyList()
)