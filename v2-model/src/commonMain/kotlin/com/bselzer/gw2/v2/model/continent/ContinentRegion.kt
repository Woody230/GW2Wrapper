package com.bselzer.gw2.v2.model.continent

import com.bselzer.gw2.v2.model.continent.map.ContinentMap
import com.bselzer.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContinentRegion(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("name")
    val name: String = "",

    /**
     * The two-dimensional coordinates of the region label.
     */
    @SerialName("label_coord")
    val labelCoordinates: List<Double> = emptyList(),

    /**
     * The continent dimensions.
     *
     * The first sublist contains the top-left coordinates.
     *
     * The second sublist contains the bottom-right coordinates.
     */
    @SerialName("continent_rect")
    val continentRectangle: List<List<Double>> = emptyList(),

    /**
     * A map of the map id to the map information.
     */
    @SerialName("maps")
    val maps: Map<Int, ContinentMap> = emptyMap()
) : Identifiable<Int>