package com.bselzer.library.gw2.v2.model.common.achievement.reward

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Mastery")
data class MasteryReward(
    /**
     * The id of the mastery.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">the wiki</a>
     */
    @SerialName("id")
    val id: Int = 0,

    @SerialName("region")
    val region: String = ""
) : AchievementReward()