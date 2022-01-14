package com.bselzer.gw2.v2.model.continent.map

import com.bselzer.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MapMasteryPoint(
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The two-dimensional position within the texture.
     */
    @SerialName("coord")
    val coordinates: List<Double> = emptyList(),

    @SerialName("region")
    val region: String = ""
) : Identifiable<Int>