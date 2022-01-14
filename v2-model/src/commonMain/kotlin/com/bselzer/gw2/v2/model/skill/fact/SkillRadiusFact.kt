package com.bselzer.gw2.v2.model.skill.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Radius")
data class SkillRadiusFact(
    /**
     * The radius size.
     */
    @SerialName("distance")
    val distance: Int = 0
) : SkillFact()