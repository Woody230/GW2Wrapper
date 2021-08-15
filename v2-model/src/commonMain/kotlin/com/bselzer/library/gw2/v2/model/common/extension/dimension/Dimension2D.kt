package com.bselzer.library.gw2.v2.model.common.extension.dimension

import com.bselzer.library.gw2.v2.model.common.extension.serialization.Dimension2DSerializer
import kotlinx.serialization.Serializable

@Serializable(with = Dimension2DSerializer::class)
data class Dimension2D(
    val width: Double = 0.0,
    val height: Double = 0.0
)