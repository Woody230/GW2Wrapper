package com.bselzer.library.gw2.v2.model.achievement.bit

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Text")
data class TextBit(
    val text: String = ""
) : AchievementBit()