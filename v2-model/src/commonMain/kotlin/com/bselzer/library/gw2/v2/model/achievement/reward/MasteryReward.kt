package com.bselzer.library.gw2.v2.model.achievement.reward

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
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
    override val id: Int = 0,

    @SerialName("region")
    val region: String = ""
) : AchievementReward(), Identifiable<Int>