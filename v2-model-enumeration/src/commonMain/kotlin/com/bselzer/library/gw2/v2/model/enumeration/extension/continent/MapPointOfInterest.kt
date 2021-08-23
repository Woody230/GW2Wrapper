package com.bselzer.library.gw2.v2.model.enumeration.extension.continent

import com.bselzer.library.gw2.v2.model.continent.map.MapPointOfInterest
import com.bselzer.library.gw2.v2.model.enumeration.continent.PointOfInterestType
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [MapPointOfInterest.type] as a [PointOfInterestType]
 */
fun MapPointOfInterest.type(): PointOfInterestType? = type.enumValueOrNull<PointOfInterestType>()