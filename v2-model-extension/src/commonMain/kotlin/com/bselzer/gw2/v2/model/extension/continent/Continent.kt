package com.bselzer.gw2.v2.model.extension.continent

import com.bselzer.gw2.v2.model.continent.Continent
import com.bselzer.gw2.v2.model.extension.internal.toDimension2D
import com.bselzer.ktx.geometry.dimension.bi.Dimension2D

/**
 * The [Continent.dimensions] as a [Dimension2D].
 */
fun Continent.dimensions(): Dimension2D = dimensions.toDimension2D()