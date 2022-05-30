package com.bselzer.gw2.v2.model.continent.floor

import com.bselzer.gw2.v2.model.continent.region.Region
import com.bselzer.gw2.v2.model.continent.region.RegionId
import com.bselzer.ktx.geometry.dimension.bi.Dimension2D
import com.bselzer.ktx.geometry.dimension.bi.polygon.Digon
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Floor(
    @SerialName("id")
    override val id: FloorId = FloorId(),

    /**
     * The width and height of the texture.
     */
    @SerialName("texture_dims")
    val textureDimensions: Dimension2D = Dimension2D(),

    /**
     * The bounds of this floor within the continent's texture represented by two-dimensional coordinates.
     */
    @SerialName("clamped_view")
    val clampedView: Digon = Digon(),

    /**
     * A map of the region id to the region information.
     */
    @SerialName("regions")
    val regions: Map<RegionId, Region> = emptyMap()
) : Identifiable<FloorId, Int>