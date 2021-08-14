package com.bselzer.library.gw2.v2.model.extension.common.model.mastery

import com.bselzer.library.gw2.v2.model.common.mastery.Mastery
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.map.Region
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [Mastery.region] as a [Region]
 */
fun Mastery.region(): Region? = region.enumValueOrNull<Region>()