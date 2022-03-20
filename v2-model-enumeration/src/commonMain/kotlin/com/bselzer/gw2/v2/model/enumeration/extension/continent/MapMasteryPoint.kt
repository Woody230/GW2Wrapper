package com.bselzer.gw2.v2.model.enumeration.extension.continent

import com.bselzer.gw2.v2.model.continent.map.mastery.MasteryPoint
import com.bselzer.gw2.v2.model.enumeration.continent.RegionName
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [MasteryPoint.region] as a [RegionName]
 */
fun MasteryPoint.region(): RegionName? = region.enumValueOrNull<RegionName>()