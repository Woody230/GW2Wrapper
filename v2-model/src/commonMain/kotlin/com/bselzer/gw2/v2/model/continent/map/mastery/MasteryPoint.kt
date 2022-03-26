package com.bselzer.gw2.v2.model.continent.map.mastery

import com.bselzer.gw2.v2.model.enumeration.wrapper.RegionType
import com.bselzer.gw2.v2.model.mastery.MasteryId
import com.bselzer.ktx.geometry.dimension.bi.position.Point2D
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MasteryPoint(
    @SerialName("id")
    override val id: MasteryId = MasteryId(),

    /**
     * The two-dimensional position within the texture.
     */
    @SerialName("coord")
    val coordinates: Point2D = Point2D(),

    /**
     * The name of the region the mastery is located in.
     */
    @SerialName("region")
    val region: RegionType = RegionType()
) : Identifiable<Int>