package com.bselzer.gw2.v2.model.enumeration.extension.wvw

import com.bselzer.gw2.v2.model.enumeration.wvw.MapType
import com.bselzer.gw2.v2.model.enumeration.wvw.ObjectiveType
import com.bselzer.gw2.v2.model.wvw.objective.WvwObjective
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [WvwObjective.type] as an [ObjectiveType]
 */
fun WvwObjective.type(): ObjectiveType? = type.enumValueOrNull<ObjectiveType>()

/**
 * The [WvwObjective.mapType] as a [MapType]
 */
fun WvwObjective.mapType(): MapType? = mapType.enumValueOrNull<MapType>()