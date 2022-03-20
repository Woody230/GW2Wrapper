package com.bselzer.gw2.v2.model.account.slot

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.item.ItemId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A legendary armory item.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/legendaryarmory">the wiki</a>
 */
@Serializable
data class ArmoryItem(
    /**
     * The id of the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki: items</a>
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legendaryarmory">the wiki: legendary armory</a>
     */
    @SerialName("id")
    override val id: ItemId = ItemId(),

    /**
     * The number of this item available for use in a single equipment template.
     */
    @SerialName("count")
    val count: Int = 0
) : Identifiable<Int>