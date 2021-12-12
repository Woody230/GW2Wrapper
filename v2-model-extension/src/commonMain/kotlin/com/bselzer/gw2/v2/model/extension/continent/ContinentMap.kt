package com.bselzer.gw2.v2.model.extension.continent

import com.bselzer.gw2.v2.model.continent.map.ContinentMap
import com.bselzer.gw2.v2.model.extension.internal.toDigon
import com.bselzer.ktx.geometry.dimension.bi.polygon.Digon

/**
 * The [ContinentMap.mapRectangle] as a [Digon].
 */
fun ContinentMap.mapRectangle(): Digon = mapRectangle.toDigon()

/**
 * The [ContinentMap.continentRectangle] as a [Digon].
 */
fun ContinentMap.continentRectangle(): Digon = continentRectangle.toDigon()