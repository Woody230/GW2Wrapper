package com.bselzer.library.gw2.v2.model.common.achievement.reward

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Item")
data class ItemReward(
    /**
     * The id of the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("count")
    val count: Int = 0
) : AchievementReward(), Identifiable<Int>