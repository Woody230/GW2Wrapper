package com.bselzer.library.gw2.v2.model.trait.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("ComboField")
data class TraitComboFieldFact(
    /**
     * The type of combo field.
     */
    @SerialName("field_type")
    val fieldType: String = ""
) : TraitFact()