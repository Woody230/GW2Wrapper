package com.bselzer.library.gw2.v2.model.common.continent.map

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import com.bselzer.library.gw2.v2.model.common.extension.dimension.Point2D
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MapMasteryPoint(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("coord")
    val coordinates: Point2D = Point2D(),

    @SerialName("region")
    val region: String = ""
) : Identifiable<Int>