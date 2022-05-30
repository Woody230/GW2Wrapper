package com.bselzer.gw2.v2.model.achievement.category

import com.bselzer.gw2.v2.model.achievement.AchievementAccess
import com.bselzer.gw2.v2.model.achievement.AchievementId
import com.bselzer.gw2.v2.model.achievement.AchievementLevel
import com.bselzer.gw2.v2.model.enumeration.wrapper.CategoryAchievementFlag
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @since 2022-03-23T19:00:00.000Z
 */
@Serializable
data class CategoryAchievement(
    @SerialName("id")
    override val id: AchievementId = AchievementId(),

    /**
     * The expansion access requirements.
     */
    @SerialName("required_access")
    val access: AchievementAccess = AchievementAccess(),

    /**
     * The level requirements.
     */
    @SerialName("level")
    val level: AchievementLevel = AchievementLevel(),

    /**
     * The flags indicating the categories this achievement belongs to.
     */
    @SerialName("flags")
    val flags: List<CategoryAchievementFlag> = emptyList(),
) : Identifiable<AchievementId, Int>