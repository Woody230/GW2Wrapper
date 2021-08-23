package com.bselzer.library.gw2.v2.model.enumeration.extension.map

import com.bselzer.library.gw2.v2.model.enumeration.map.MapType
import com.bselzer.library.gw2.v2.model.map.Map
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [Map.type] as a [MapType]
 */
fun Map.type(): MapType? = type.enumValueOrNull<MapType>()