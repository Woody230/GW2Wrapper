package com.bselzer.library.gw2.v2.model.continent

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import com.bselzer.library.kotlin.extension.geometry.dimension.bi.Dimension
import com.bselzer.library.kotlin.extension.geometry.dimension.bi.polygon.Digon
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
    val textureDimensions: Dimension = Dimension(),

    /**
     * The bounds of this floor within the continent's texture.
     */
    @SerialName("clamped_view")
    val clampedView: Digon = Digon(),

    /**
     * A map of the region id to the region information.
     */
    @SerialName("regions")
    val regions: Map<Int, ContinentRegion> = emptyMap()
) : Identifiable<Int>