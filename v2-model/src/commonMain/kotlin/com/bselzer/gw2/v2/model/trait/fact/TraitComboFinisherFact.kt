package com.bselzer.gw2.v2.model.trait.fact

import com.bselzer.gw2.v2.model.wrapper.ComboFinisherType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("ComboFinisher")
data class TraitComboFinisherFact(
    /**
     * The type of combo finisher.
     */
    @SerialName("finisher_type")
    val finisherType: ComboFinisherType = ComboFinisherType(),

    /**
     * The percentage chance that the finisher will trigger.
     */
    @SerialName("percent")
    val percent: Double = 0.0
) : TraitFact()