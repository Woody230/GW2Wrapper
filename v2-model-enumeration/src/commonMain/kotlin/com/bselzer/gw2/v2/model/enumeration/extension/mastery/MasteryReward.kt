package com.bselzer.gw2.v2.model.enumeration.extension.mastery

import com.bselzer.gw2.v2.model.achievement.reward.MasteryReward
import com.bselzer.gw2.v2.model.enumeration.continent.RegionName
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [MasteryReward.region] as a [RegionName]
 */
fun MasteryReward.region(): RegionName? = region.enumValueOrNull<RegionName>()