package com.bselzer.library.gw2.v2.model.common.achievement

import com.bselzer.library.gw2.v2.model.common.achievement.bit.AchievementBit
import com.bselzer.library.gw2.v2.model.common.achievement.reward.AchievementReward
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Achievement(
    @SerialName("id")
    val id: Int = 0,

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("name")
    val name: String = "",

    /**
     * The description of the achievement.
     */
    @SerialName("description")
    val description: String = "",

    /**
     * The requirement(s) to unlock the achievement.
     */
    @SerialName("requirement")
    val requirements: String = "",

    /**
     * The description of the achievement before it is unlocked.
     */
    @SerialName("locked_text")
    val lockedDescription: String = "",

    @SerialName("type")
    val type: String = "",

    /**
     * The flags indicating the categories this achievement belongs to.
     */
    @SerialName("flags")
    val flags: List<String> = emptyList(),

    /**
     * The progression tiers.
     */
    @SerialName("tiers")
    val tiers: List<AchievementTier> = emptyList(),

    /**
     * The ids of achievements needed to progress this achievement.
     */
    @SerialName("prerequisites")
    val prerequisites: List<Int> = emptyList(),

    /**
     * The rewards for completing this achievement.
     */
    @SerialName("rewards")
    val rewards: List<AchievementReward> = emptyList(),

    /**
     * Related information about progressing the achievement.
     */
    @SerialName("bits")
    val bits: List<AchievementBit> = emptyList(),

    /**
     * The maximum number of achievement points that can be rewarded by repeatable achievements.
     */
    @SerialName("point_cap")
    val pointCap: Int = 0
)