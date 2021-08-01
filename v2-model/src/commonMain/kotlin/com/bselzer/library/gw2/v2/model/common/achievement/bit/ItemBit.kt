package com.bselzer.library.gw2.v2.model.common.achievement.bit

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Item")
data class ItemBit(
    /**
     * The id of the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("id")
    val id: Int = 0
) : AchievementBit()