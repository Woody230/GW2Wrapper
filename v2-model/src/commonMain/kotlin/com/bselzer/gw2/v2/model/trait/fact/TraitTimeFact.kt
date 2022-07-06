package com.bselzer.gw2.v2.model.trait.fact

import com.bselzer.ktx.serialization.serializer.SecondDurationSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Duration

@Serializable
@SerialName("Time")
data class TraitTimeFact(
    /**
     * The time value in seconds.
     */
    @Serializable(with = SecondDurationSerializer::class)
    @SerialName("duration")
    val duration: Duration = Duration.ZERO
) : TraitFact()