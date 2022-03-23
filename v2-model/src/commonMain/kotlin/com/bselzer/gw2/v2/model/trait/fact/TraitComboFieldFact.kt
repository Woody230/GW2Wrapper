package com.bselzer.gw2.v2.model.trait.fact

import com.bselzer.gw2.v2.model.enumeration.wrapper.ComboFieldType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("ComboField")
data class TraitComboFieldFact(
    /**
     * The type of combo field.
     */
    @SerialName("field_type")
    val fieldType: ComboFieldType = ComboFieldType()
) : TraitFact()