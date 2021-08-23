package com.bselzer.library.gw2.v2.model.enumeration.extension.mastery

import com.bselzer.library.gw2.v2.model.enumeration.continent.RegionName
import com.bselzer.library.gw2.v2.model.mastery.Mastery
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [Mastery.region] as a [RegionName]
 */
fun Mastery.region(): RegionName? = region.enumValueOrNull<RegionName>()