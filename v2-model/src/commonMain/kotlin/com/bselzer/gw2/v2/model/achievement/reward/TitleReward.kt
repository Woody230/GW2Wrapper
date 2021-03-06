package com.bselzer.gw2.v2.model.achievement.reward

import com.bselzer.gw2.v2.model.title.TitleId
import com.bselzer.ktx.value.identifier.Identifiable
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
    override val id: TitleId = TitleId()
) : AchievementReward(), Identifiable<TitleId, Int>