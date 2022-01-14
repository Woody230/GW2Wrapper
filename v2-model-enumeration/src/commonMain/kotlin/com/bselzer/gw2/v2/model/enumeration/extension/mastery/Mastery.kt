package com.bselzer.gw2.v2.model.enumeration.extension.mastery

import com.bselzer.gw2.v2.model.enumeration.continent.RegionName
import com.bselzer.gw2.v2.model.mastery.Mastery
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [Mastery.region] as a [RegionName]
 */
fun Mastery.region(): RegionName? = region.enumValueOrNull<RegionName>()