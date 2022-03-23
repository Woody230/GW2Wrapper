package com.bselzer.gw2.v2.model.achievement.reward

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.mastery.MasteryId
import com.bselzer.gw2.v2.model.wrapper.RegionType
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
    override val id: MasteryId = MasteryId(),

    @SerialName("region")
    val region: RegionType = RegionType()
) : AchievementReward(), Identifiable<Int>