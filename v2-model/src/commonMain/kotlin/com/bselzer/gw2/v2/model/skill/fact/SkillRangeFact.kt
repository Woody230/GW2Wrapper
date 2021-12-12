package com.bselzer.gw2.v2.model.skill.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Range")
data class SkillRangeFact(
    /**
     * The amount of range.
     */
    @SerialName("value")
    val value: Int = 0
) : SkillFact()