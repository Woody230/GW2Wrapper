package com.bselzer.library.gw2.v2.model.extension.common.model.continent

import com.bselzer.library.gw2.v2.model.common.continent.map.MapPointOfInterest
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.continent.PointOfInterestType
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [MapPointOfInterest.type] as a [PointOfInterestType]
 */
fun MapPointOfInterest.type(): PointOfInterestType? = type.enumValueOrNull<PointOfInterestType>()