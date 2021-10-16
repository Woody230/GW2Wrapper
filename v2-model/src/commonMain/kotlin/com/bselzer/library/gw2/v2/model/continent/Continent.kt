package com.bselzer.library.gw2.v2.model.continent

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import com.bselzer.library.kotlin.extension.geometry.dimension.bi.Dimension
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Continent(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("name")
    val name: String = "",

    /**
     * The width and height of the continent.
     */
    @SerialName("continent_dims")
    val continentDimensions: Dimension = Dimension(),

    @SerialName("min_zoom")
    val minZoom: Int = 0,

    @SerialName("max_zoom")
    val maxZoom: Int = 0,

    /**
     * The ids of the floors.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    @SerialName("floors")
    val floorIds: List<Int> = emptyList()
) : Identifiable<Int>