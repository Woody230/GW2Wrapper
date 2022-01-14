package com.bselzer.gw2.v2.model.trait.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("AttributeAdjust")
data class TraitAttributeAdjustFact(
    /**
     * The amount the [target] attribute is adjusted by for a level 80 character.
     */
    @SerialName("value")
    val value: Int = 0,

    /**
     * The name of the attribute to adjust.
     */
    @SerialName("target")
    val target: String = ""
) : TraitFact()