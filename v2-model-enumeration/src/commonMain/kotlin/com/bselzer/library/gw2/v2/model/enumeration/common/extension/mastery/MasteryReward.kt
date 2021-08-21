package com.bselzer.library.gw2.v2.model.enumeration.common.extension.mastery

import com.bselzer.library.gw2.v2.model.common.achievement.reward.MasteryReward
import com.bselzer.library.gw2.v2.model.enumeration.common.continent.RegionName
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [MasteryReward.region] as a [RegionName]
 */
fun MasteryReward.region(): RegionName? = region.enumValueOrNull<RegionName>()