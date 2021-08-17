package com.bselzer.library.gw2.v2.model.common.account

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
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
    override val id: Int = 0,

    /**
     * The number of this item available for use in a single equipment template.
     */
    @SerialName("count")
    val count: Int = 0
) : Identifiable<Int>