package com.bselzer.library.gw2.v2.model.common.continent.map

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import com.bselzer.library.gw2.v2.model.common.extension.dimension.Point2D
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MapAdventure(
    /**
     * The id in the form of a UUID.
     */
    @SerialName("id")
    override val id: String = "",

    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    @SerialName("coord")
    val coordinates: Point2D = Point2D()
) : Identifiable<String>