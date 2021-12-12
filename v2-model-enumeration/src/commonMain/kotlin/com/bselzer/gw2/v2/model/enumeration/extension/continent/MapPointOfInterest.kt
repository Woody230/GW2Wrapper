package com.bselzer.gw2.v2.model.enumeration.extension.continent

import com.bselzer.gw2.v2.model.continent.map.MapPointOfInterest
import com.bselzer.gw2.v2.model.enumeration.continent.PointOfInterestType
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [MapPointOfInterest.type] as a [PointOfInterestType]
 */
fun MapPointOfInterest.type(): PointOfInterestType? = type.enumValueOrNull<PointOfInterestType>()