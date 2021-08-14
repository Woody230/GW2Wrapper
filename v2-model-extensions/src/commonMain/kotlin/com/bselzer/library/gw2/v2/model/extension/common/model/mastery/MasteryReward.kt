package com.bselzer.library.gw2.v2.model.extension.common.model.mastery

import com.bselzer.library.gw2.v2.model.common.achievement.reward.MasteryReward
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.map.Region
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [MasteryReward.region] as a [Region]
 */
fun MasteryReward.region(): Region? = region.enumValueOrNull<Region>()