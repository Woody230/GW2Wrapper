package com.bselzer.library.gw2.v2.model.extension.common.model.map

import com.bselzer.library.gw2.v2.model.common.map.Map
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.map.MapType
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [Map.type] as a [MapType]
 */
fun Map.type(): MapType? = type.enumValueOrNull<MapType>()