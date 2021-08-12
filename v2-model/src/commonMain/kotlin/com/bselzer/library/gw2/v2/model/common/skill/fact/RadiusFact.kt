package com.bselzer.library.gw2.v2.model.common.skill.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Radius")
data class RadiusFact(
    /**
     * The radius size.
     */
    @SerialName("distance")
    val distance: Int = 0
) : SkillFact()