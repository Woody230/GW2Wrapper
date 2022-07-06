package com.bselzer.gw2.v2.model.trait.fact

import com.bselzer.ktx.serialization.serializer.SecondDurationSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Duration

@Serializable
@SerialName("Recharge")
data class TraitRechargeFact(
    /**
     * The recharge time in seconds.
     */
    @Serializable(with = SecondDurationSerializer::class)
    @SerialName("value")
    val value: Duration = Duration.ZERO
) : TraitFact()