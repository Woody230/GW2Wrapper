package com.bselzer.gw2.v2.model.title

import com.bselzer.gw2.v2.model.achievement.AchievementId
import com.bselzer.gw2.v2.model.achievement.AchievementPoints
import com.bselzer.gw2.v2.model.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Title(
    @SerialName("id")
    override val id: TitleId = TitleId(),

    @SerialName("name")
    val name: String = "",

    /**
     * The ids of the achievements required to grant the title.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">the wiki</a>
     */
    @SerialName("achievements")
    val achievementIds: List<AchievementId> = emptyList(),

    /**
     * The number of achievement points required to grant the title.
     *
     * Null if achievement points are not required
     */
    @SerialName("ap_required")
    val achievementPointsRequired: AchievementPoints? = null
) : Identifiable<Int>