package com.bselzer.library.gw2.v2.model.skill.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Percent")
data class SkillPercentFact(
    /**
     * The percentage amount associated with the [description]
     */
    @SerialName("percent")
    val percent: Double = 0.0
) : SkillFact()