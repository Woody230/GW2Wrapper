package com.bselzer.gw2.v2.model.skill.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("ComboFinisher")
data class SkillComboFinisherFact(
    /**
     * The type of combo finisher.
     */
    @SerialName("finisher_type")
    val finisherType: String = "",

    /**
     * The percentage chance that the finisher will trigger.
     */
    @SerialName("percent")
    val percent: Double = 0.0
) : SkillFact()