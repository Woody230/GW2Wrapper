package com.bselzer.gw2.v2.model.achievement.tier

import com.bselzer.gw2.v2.model.achievement.AchievementPoints
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AchievementTier(
    /**
     * The amount of requirements that need to be completed for this tier to be achieved.
     */
    @SerialName("count")
    val count: Int = 0,

    /**
     * The amount of achievement points (AP) awarded for completing this tier.
     */
    @SerialName("points")
    val points: AchievementPoints = AchievementPoints()
)