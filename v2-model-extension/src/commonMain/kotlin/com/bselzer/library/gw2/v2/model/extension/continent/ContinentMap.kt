package com.bselzer.library.gw2.v2.model.extension.continent

import com.bselzer.library.gw2.v2.model.continent.map.ContinentMap
import com.bselzer.library.gw2.v2.model.extension.internal.toDigon
import com.bselzer.library.kotlin.extension.geometry.dimension.bi.polygon.Digon

/**
 * The [ContinentMap.mapRectangle] as a [Digon].
 */
fun ContinentMap.mapRectangle(): Digon = mapRectangle.toDigon()

/**
 * The [ContinentMap.continentRectangle] as a [Digon].
 */
fun ContinentMap.continentRectangle(): Digon = continentRectangle.toDigon()