package com.bselzer.gw2.v2.model.enumeration.extension.wvw

import com.bselzer.gw2.v2.model.enumeration.wvw.MapType
import com.bselzer.gw2.v2.model.wvw.match.WvwMap
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [WvwMap.type] as a [MapType]
 */
fun WvwMap.type(): MapType? = type.enumValueOrNull<MapType>()
