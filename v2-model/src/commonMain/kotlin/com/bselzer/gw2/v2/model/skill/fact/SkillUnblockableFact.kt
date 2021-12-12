package com.bselzer.gw2.v2.model.skill.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Unblockable")
data class SkillUnblockableFact(
    /**
     * Whether the effect is unblockable.
     */
    @SerialName("value")
    val value: Boolean = false
) : SkillFact()