package com.bselzer.gw2.v2.model.trait.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Distance")
data class TraitDistanceFact(
    /**
     * The amount of distance.
     */
    @SerialName("distance")
    val distance: Int = 0
) : TraitFact()