package com.bselzer.library.gw2.v2.model.skill.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Range")
data class RangeFact(
    /**
     * The amount of range.
     */
    @SerialName("value")
    val value: Int = 0
) : SkillFact()