package com.bselzer.library.gw2.v2.model.enumeration.extension.continent

import com.bselzer.library.gw2.v2.model.continent.map.MapMasteryPoint
import com.bselzer.library.gw2.v2.model.enumeration.continent.RegionName
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [MapMasteryPoint.region] as a [RegionName]
 */
fun MapMasteryPoint.region(): RegionName? = region.enumValueOrNull<RegionName>()