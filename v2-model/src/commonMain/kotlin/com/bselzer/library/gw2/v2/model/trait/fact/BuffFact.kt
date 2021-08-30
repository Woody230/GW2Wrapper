package com.bselzer.library.gw2.v2.model.trait.fact

import com.bselzer.library.gw2.v2.model.extension.serialization.SecondDurationSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@Serializable
@SerialName("Buff")
data class BuffFact(
    /**
     * The boon or condition affected by this fact.
     */
    @SerialName("status")
    val status: String = "",

    /**
     * The description of the effect.
     */
    @SerialName("description")
    val effectDescription: String = "",

    /**
     * The number of stacks applied.
     */
    @SerialName("apply_count")
    val count: Int = 0,

    /**
     * The duration of the effect in seconds.
     */
    @Serializable(with = SecondDurationSerializer::class)
    @SerialName("duration")
    val duration: Duration = Duration.ZERO
) : TraitFact()