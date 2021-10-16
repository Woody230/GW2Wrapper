package com.bselzer.library.gw2.v2.model.continent.map

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import com.bselzer.library.kotlin.extension.geometry.dimension.bi.position.Point
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MapMasteryPoint(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("coord")
    val coordinates: Point = Point(),

    @SerialName("region")
    val region: String = ""
) : Identifiable<Int>