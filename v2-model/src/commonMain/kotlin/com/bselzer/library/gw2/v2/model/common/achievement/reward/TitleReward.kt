package com.bselzer.library.gw2.v2.model.common.achievement.reward

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Title")
data class TitleReward(
    /**
     * The id of the title.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/titles">the wiki</a>
     */
    @SerialName("id")
    val id: Int = 0
) : AchievementReward()