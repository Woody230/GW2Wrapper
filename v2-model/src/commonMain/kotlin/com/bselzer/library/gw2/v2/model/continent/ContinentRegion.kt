package com.bselzer.library.gw2.v2.model.continent

import com.bselzer.library.gw2.v2.model.continent.map.ContinentMap
import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import com.bselzer.library.kotlin.extension.geometry.dimension.bi.polygon.Digon
import com.bselzer.library.kotlin.extension.geometry.dimension.bi.position.Point2D
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContinentRegion(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("name")
    val name: String = "",

    /**
     * The coordinates of the region label.
     */
    @SerialName("label_coord")
    val labelCoordinates: Point2D = Point2D(),

    /**
     * The continent dimensions.
     *
     * [Digon.point1] contains the top-left coordinates.
     *
     * [Digon.point2] contains the bottom-right coordinates.
     */
    @SerialName("continent_rect")
    val continentRectangle: Digon = Digon(),

    /**
     * A map of the map id to the map information.
     */
    @SerialName("maps")
    val maps: Map<Int, ContinentMap> = emptyMap()
) : Identifiable<Int>