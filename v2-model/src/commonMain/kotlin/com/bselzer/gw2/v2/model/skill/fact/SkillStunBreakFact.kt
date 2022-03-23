package com.bselzer.gw2.v2.model.skill.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("StunBreak")
data class SkillStunBreakFact(
    /**
     * Whether the effect is a stun break.
     */
    @SerialName("value")
    val value: Boolean = false
) : SkillFact()