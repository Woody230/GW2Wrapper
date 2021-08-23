package com.bselzer.library.gw2.v2.model.continent

import com.bselzer.library.gw2.v2.model.continent.map.ContinentMap
import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import com.bselzer.library.gw2.v2.model.extension.dimension.Point2D
import com.bselzer.library.gw2.v2.model.extension.dimension.Rectangle
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
     * [Rectangle.x1] and [Rectangle.y1] are the top-left coordinates.
     *
     * [Rectangle.x2] and [Rectangle.y2] are the bottom-right coordinates.
     */
    @SerialName("continent_rect")
    val continentRectangle: Rectangle = Rectangle(),

    /**
     * A map of the map id to the map information.
     */
    @SerialName("maps")
    val maps: Map<Int, ContinentMap> = emptyMap()
) : Identifiable<Int>