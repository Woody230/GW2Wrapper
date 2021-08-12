package com.bselzer.library.gw2.v2.model.common.trait.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("ComboFinisher")
data class ComboFinisherFact(
    /**
     * The type of combo finisher.
     */
    @SerialName("finisher_type")
    val finisherType: String = "",

    /**
     * The percentage chance that the finisher will trigger.
     */
    @SerialName("percent")
    val percent: Double = 0.0
) : TraitFact()