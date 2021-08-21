package com.bselzer.library.gw2.v2.model.extension.common.model.mastery

import com.bselzer.library.gw2.v2.model.common.mastery.Mastery
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.continent.RegionName
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [Mastery.region] as a [RegionName]
 */
fun Mastery.region(): RegionName? = region.enumValueOrNull<RegionName>()