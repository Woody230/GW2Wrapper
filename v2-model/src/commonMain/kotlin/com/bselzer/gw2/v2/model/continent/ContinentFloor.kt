package com.bselzer.gw2.v2.model.continent

import com.bselzer.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContinentFloor(
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The width and height of the texture.
     */
    @SerialName("texture_dims")
    val textureDimensions: List<Double> = emptyList(),

    /**
     * The bounds of this floor within the continent's texture represented by two-dimensional coordinates.
     */
    @SerialName("clamped_view")
    val clampedView: List<List<Double>>,

    /**
     * A map of the region id to the region information.
     */
    @SerialName("regions")
    val regions: Map<Int, ContinentRegion> = emptyMap()
) : Identifiable<Int>