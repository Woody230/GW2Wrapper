package com.bselzer.library.gw2.v2.model.enumeration.extension.wvw

import com.bselzer.library.gw2.v2.model.enumeration.wvw.MapType
import com.bselzer.library.gw2.v2.model.wvw.match.WvwMap
import com.bselzer.library.kotlin.extension.function.objects.enumValueOrNull

/**
 * The [WvwMap.type] as a [MapType]
 */
fun WvwMap.type(): MapType? = type.enumValueOrNull<MapType>()
