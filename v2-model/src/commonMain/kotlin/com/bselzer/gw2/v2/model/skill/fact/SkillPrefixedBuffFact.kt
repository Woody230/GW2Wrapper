package com.bselzer.gw2.v2.model.skill.fact

import com.bselzer.ktx.datetime.serialization.SecondDurationSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Duration

@Serializable
@SerialName("PrefixedBuff")
data class SkillPrefixedBuffFact(
    /**
     * The boon or condition affected by this fact.
     */
    @SerialName("status")
    val status: com.bselzer.gw2.v2.model.wrapper.EffectName = com.bselzer.gw2.v2.model.wrapper.EffectName(),

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
    val duration: Duration = Duration.ZERO,

    /**
     * Describes the icon to show before the fact.
     */
    @SerialName("prefix")
    val prefix: SkillBuffPrefix = SkillBuffPrefix()
) : SkillFact()