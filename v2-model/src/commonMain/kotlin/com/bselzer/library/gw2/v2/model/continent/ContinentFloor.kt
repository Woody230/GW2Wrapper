package com.bselzer.library.gw2.v2.model.continent

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import com.bselzer.library.gw2.v2.model.extension.dimension.Point2D
import com.bselzer.library.gw2.v2.model.extension.dimension.Rectangle
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContinentFloor(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("texture_dims")
    val textureDimensions: Point2D = Point2D(),

    @SerialName("clamped_view")
    val clampedView: Rectangle = Rectangle(),

    /**
     * A map of the region id to the region information.
     */
    @SerialName("regions")
    val regions: Map<Int, ContinentRegion> = emptyMap()
) : Identifiable<Int>