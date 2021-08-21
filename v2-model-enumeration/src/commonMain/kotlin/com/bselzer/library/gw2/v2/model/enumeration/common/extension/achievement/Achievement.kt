package com.bselzer.library.gw2.v2.model.enumeration.common.extension.achievement

import com.bselzer.library.gw2.v2.model.common.achievement.Achievement
import com.bselzer.library.gw2.v2.model.enumeration.common.achievement.AchievementFlag
import com.bselzer.library.gw2.v2.model.enumeration.common.achievement.AchievementType
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

/**
 * The [Achievement.type] as an [AchievementType]
 */
fun Achievement.type(): AchievementType? = type.enumValueOrNull<AchievementType>()

/**
 * The [Achievement.flags] as a collection of [AchievementFlag]
 */
fun Achievement.flags(): List<AchievementFlag> = flags.validEnumValues()