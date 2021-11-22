package com.bselzer.library.gw2.v2.model.continent.map

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MapHeroChallenge(
    /**
     * The id of the hero challenge in the form of a two integers split by a dash.
     * The first number represents the expansion, starting at 0 for the base game.
     */
    @SerialName("id")
    override val id: String = "",

    /**
     * The two-dimensional coordinates within the texture.
     */
    @SerialName("coord")
    val coordinates: List<Double> = emptyList()
) : Identifiable<String>