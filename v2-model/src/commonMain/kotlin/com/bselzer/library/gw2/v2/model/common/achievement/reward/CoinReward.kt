package com.bselzer.library.gw2.v2.model.common.achievement.reward

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Coins")
data class CoinReward(
    @SerialName("count")
    val count: Int = 0
) : AchievementReward()