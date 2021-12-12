package com.bselzer.gw2.v2.model.achievement.reward

import kotlinx.serialization.Serializable

@Serializable
abstract class AchievementReward {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false
        return true
    }

    override fun hashCode(): Int {
        return this::class.hashCode()
    }
}
