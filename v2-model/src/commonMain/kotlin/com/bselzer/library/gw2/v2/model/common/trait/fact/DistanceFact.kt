package com.bselzer.library.gw2.v2.model.common.trait.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Distance")
data class DistanceFact(
    /**
     * The amount of distance.
     */
    @SerialName("distance")
    val distance: Int = 0
) : TraitFact()