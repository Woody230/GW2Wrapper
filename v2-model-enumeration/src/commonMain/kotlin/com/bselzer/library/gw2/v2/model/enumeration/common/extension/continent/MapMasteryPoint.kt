package com.bselzer.library.gw2.v2.model.enumeration.common.extension.continent

import com.bselzer.library.gw2.v2.model.common.continent.map.MapMasteryPoint
import com.bselzer.library.gw2.v2.model.enumeration.common.continent.RegionName
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [MapMasteryPoint.region] as a [RegionName]
 */
fun MapMasteryPoint.region(): RegionName? = region.enumValueOrNull<RegionName>()