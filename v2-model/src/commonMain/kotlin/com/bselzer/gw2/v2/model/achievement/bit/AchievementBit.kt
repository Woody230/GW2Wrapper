package com.bselzer.gw2.v2.model.achievement.bit

import kotlinx.serialization.Serializable

@Serializable
abstract class AchievementBit {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false
        return true
    }

    override fun hashCode(): Int {
        return this::class.hashCode()
    }
}