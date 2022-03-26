package com.bselzer.gw2.v2.model.achievement

import com.bselzer.gw2.v2.model.achievement.bit.AchievementBit
import com.bselzer.gw2.v2.model.achievement.reward.AchievementReward
import com.bselzer.gw2.v2.model.achievement.tier.AchievementTier
import com.bselzer.gw2.v2.model.enumeration.wrapper.AchievementFlag
import com.bselzer.gw2.v2.model.enumeration.wrapper.AchievementType
import com.bselzer.gw2.v2.model.wrapper.ImageLink
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Achievement(
    @SerialName("id")
    override val id: AchievementId = AchievementId(),

    @SerialName("icon")
    val iconLink: ImageLink = ImageLink(),

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
    val type: AchievementType = AchievementType(),

    /**
     * The flags indicating the categories this achievement belongs to.
     */
    @SerialName("flags")
    val flags: List<AchievementFlag> = emptyList(),

    /**
     * The progression tiers.
     */
    @SerialName("tiers")
    val tiers: List<AchievementTier> = emptyList(),

    /**
     * The ids of achievements needed to progress this achievement.
     */
    @SerialName("prerequisites")
    val prerequisites: List<AchievementId> = emptyList(),

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
    val pointCap: AchievementPoints = AchievementPoints()
) : Identifiable<Int>