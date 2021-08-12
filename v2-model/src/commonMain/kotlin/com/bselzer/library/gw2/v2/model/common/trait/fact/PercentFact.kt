package com.bselzer.library.gw2.v2.model.common.trait.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Percent")
data class PercentFact(
    /**
     * The percentage amount associated with the [description]
     */
    @SerialName("percent")
    val percent: Double = 0.0
) : TraitFact()