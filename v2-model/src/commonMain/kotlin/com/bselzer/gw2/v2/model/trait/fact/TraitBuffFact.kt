package com.bselzer.gw2.v2.model.trait.fact

import com.bselzer.gw2.v2.model.enumeration.wrapper.EffectName
import com.bselzer.ktx.serialization.serializer.SecondDurationSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Duration

@Serializable
@SerialName("Buff")
data class TraitBuffFact(
    /**
     * The boon or condition affected by this fact.
     */
    @SerialName("status")
    val status: EffectName = EffectName(),

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