package com.bselzer.gw2.v2.model.trait.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Range")
data class TraitRangeFact(
    /**
     * The amount of range.
     */
    @SerialName("value")
    val value: Int = 0
) : TraitFact()