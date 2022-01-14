package com.bselzer.gw2.v2.model.enumeration.extension.map

import com.bselzer.gw2.v2.model.enumeration.map.MapType
import com.bselzer.gw2.v2.model.map.Map
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [Map.type] as a [MapType]
 */
fun Map.type(): MapType? = type.enumValueOrNull<MapType>()