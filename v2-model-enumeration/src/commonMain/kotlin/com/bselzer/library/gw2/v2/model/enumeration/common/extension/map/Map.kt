package com.bselzer.library.gw2.v2.model.enumeration.common.extension.map

import com.bselzer.library.gw2.v2.model.common.map.Map
import com.bselzer.library.gw2.v2.model.enumeration.common.map.MapType
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [Map.type] as a [MapType]
 */
fun Map.type(): MapType? = type.enumValueOrNull<MapType>()