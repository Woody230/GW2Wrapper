package com.bselzer.library.gw2.v2.model.common.skill.fact

import com.bselzer.library.gw2.v2.model.common.extension.serialization.SecondDurationSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@Serializable
@SerialName("Duration")
data class DurationFact(
    /**
     * The duration of the effect in seconds.
     */
    @Serializable(with = SecondDurationSerializer::class)
    @SerialName("duration")
    val duration: Duration = Duration.ZERO
) : SkillFact()