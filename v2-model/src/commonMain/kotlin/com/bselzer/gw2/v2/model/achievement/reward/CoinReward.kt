package com.bselzer.gw2.v2.model.achievement.reward

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Coins")
data class CoinReward(
    @SerialName("count")
    val count: Int = 0
) : AchievementReward()