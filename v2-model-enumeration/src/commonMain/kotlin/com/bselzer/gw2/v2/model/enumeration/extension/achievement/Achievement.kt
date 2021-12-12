package com.bselzer.gw2.v2.model.enumeration.extension.achievement

import com.bselzer.gw2.v2.model.achievement.Achievement
import com.bselzer.gw2.v2.model.enumeration.achievement.AchievementFlag
import com.bselzer.gw2.v2.model.enumeration.achievement.AchievementType
import com.bselzer.ktx.serialization.function.enumValueOrNull
import com.bselzer.ktx.serialization.function.validEnumValues

/**
 * The [Achievement.type] as an [AchievementType]
 */
fun Achievement.type(): AchievementType? = type.enumValueOrNull<AchievementType>()

/**
 * The [Achievement.flags] as a collection of [AchievementFlag]
 */
fun Achievement.flags(): List<AchievementFlag> = flags.validEnumValues()