package com.bselzer.library.gw2.v2.model.continent.map

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import com.bselzer.library.kotlin.extension.geometry.position.Point2D
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

    @SerialName("coord")
    val coordinates: Point2D = Point2D()
) : Identifiable<String>