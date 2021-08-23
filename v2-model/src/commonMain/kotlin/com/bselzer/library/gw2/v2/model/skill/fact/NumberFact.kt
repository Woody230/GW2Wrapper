package com.bselzer.library.gw2.v2.model.skill.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Number")
data class NumberFact(
    /**
     * The amount associated with the [description]
     */
    @SerialName("value")
    val value: Int = 0
) : SkillFact()