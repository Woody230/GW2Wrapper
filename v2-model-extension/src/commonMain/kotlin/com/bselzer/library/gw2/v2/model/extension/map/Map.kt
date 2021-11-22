package com.bselzer.library.gw2.v2.model.extension.map

import com.bselzer.library.gw2.v2.model.extension.internal.toDigon
import com.bselzer.library.gw2.v2.model.map.Map
import com.bselzer.library.kotlin.extension.geometry.dimension.bi.polygon.Digon

/**
 * The [Map.mapRectangle] as a [Digon].
 */
fun Map.mapRectangle(): Digon = mapRectangle.toDigon()

/**
 * The [Map.continentRectangle] as a [Digon].
 */
fun Map.continentRectangle(): Digon = continentRectangle.toDigon()