package com.bselzer.gw2.v2.model.achievement.daily

import com.bselzer.gw2.v2.model.achievement.AchievementAccess
import com.bselzer.gw2.v2.model.achievement.AchievementLevel
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Daily(
    @SerialName("id")
    override val id: DailyId = DailyId(),

    /**
     * The level requirements.
     */
    @SerialName("level")
    val level: AchievementLevel = AchievementLevel(),

    /**
     * The access requirement.
     *
     * @since 2019-05-16T00:00:00.000Z
     */
    @SerialName("access")
    val access: AchievementAccess = AchievementAccess()
) : Identifiable<Int>