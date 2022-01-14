package com.bselzer.gw2.v2.model.skill.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Number")
data class SkillNumberFact(
    /**
     * The amount associated with the [description]
     */
    @SerialName("value")
    val value: Int = 0
) : SkillFact()