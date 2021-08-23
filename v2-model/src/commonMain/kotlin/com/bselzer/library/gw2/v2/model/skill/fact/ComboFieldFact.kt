package com.bselzer.library.gw2.v2.model.skill.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("ComboField")
data class ComboFieldFact(
    /**
     * The type of combo field.
     */
    @SerialName("field_type")
    val fieldType: String = ""
) : SkillFact()