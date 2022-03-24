package com.bselzer.gw2.v2.model.achievement

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class AchievementPoints(val value: Int = 0) {
    override fun toString() = value.toString()
}