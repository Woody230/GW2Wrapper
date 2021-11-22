package com.bselzer.library.gw2.v2.model.extension.continent

import com.bselzer.library.gw2.v2.model.continent.Continent
import com.bselzer.library.gw2.v2.model.extension.internal.toDimension2D
import com.bselzer.library.kotlin.extension.geometry.dimension.bi.Dimension2D

/**
 * The [Continent.dimensions] as a [Dimension2D].
 */
fun Continent.dimensions(): Dimension2D = dimensions.toDimension2D()