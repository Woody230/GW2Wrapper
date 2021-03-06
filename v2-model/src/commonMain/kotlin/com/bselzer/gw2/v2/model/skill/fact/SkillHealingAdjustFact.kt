package com.bselzer.gw2.v2.model.skill.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("HealingAdjust")
data class SkillHealingAdjustFact(
    /**
     * The number of times the healing adjustment is applied.
     */
    @SerialName("hit_count")
    val hitCount: Int = 0
) : SkillFact()