package com.bselzer.gw2.v2.model.trait.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("BuffConversion")
data class TraitBuffConversionFact(
    /**
     * The name of the attribute to calculate the gain with.
     */
    @SerialName("source")
    val source: String = "",

    /**
     * The percentage of the [source] attribute to add to the [target] attribute
     */
    @SerialName("percent")
    val percent: Double = 0.0,

    /**
     * The name of the attribute to apply the gain to.
     */
    @SerialName("target")
    val target: String = ""
) : TraitFact()