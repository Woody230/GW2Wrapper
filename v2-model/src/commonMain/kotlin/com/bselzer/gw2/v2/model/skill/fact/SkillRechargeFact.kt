package com.bselzer.gw2.v2.model.skill.fact

import com.bselzer.ktx.serialization.serializer.SecondDurationSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Duration

@Serializable
@SerialName("Recharge")
data class SkillRechargeFact(
    /**
     * The recharge time in seconds.
     */
    @Serializable(with = SecondDurationSerializer::class)
    @SerialName("value")
    val value: Duration = Duration.ZERO
) : SkillFact()