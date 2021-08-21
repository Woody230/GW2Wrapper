package com.bselzer.library.gw2.v2.model.enumeration.common.extension.continent

import com.bselzer.library.gw2.v2.model.common.continent.map.MapPointOfInterest
import com.bselzer.library.gw2.v2.model.enumeration.common.continent.PointOfInterestType
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [MapPointOfInterest.type] as a [PointOfInterestType]
 */
fun MapPointOfInterest.type(): PointOfInterestType? = type.enumValueOrNull<PointOfInterestType>()