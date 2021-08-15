package com.bselzer.library.gw2.v2.model.extension.common.model.continent

import com.bselzer.library.gw2.v2.model.common.continent.map.MapMasteryPoint
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.continent.RegionName
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [MapMasteryPoint.region] as a [RegionName]
 */
fun MapMasteryPoint.region(): RegionName? = region.enumValueOrNull<RegionName>()