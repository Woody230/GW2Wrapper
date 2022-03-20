package com.bselzer.gw2.v2.model.enumeration.extension.continent

import com.bselzer.gw2.v2.model.continent.map.pointofinterest.PointOfInterest
import com.bselzer.gw2.v2.model.enumeration.continent.PointOfInterestType
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [PointOfInterest.type] as a [PointOfInterestType]
 */
fun PointOfInterest.type(): PointOfInterestType? = type.enumValueOrNull<PointOfInterestType>()