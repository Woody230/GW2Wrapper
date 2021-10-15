package com.bselzer.library.gw2.v2.model.trait.fact

import com.bselzer.library.kotlin.extension.datetime.serialization.SecondDurationSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@Serializable
@SerialName("Recharge")
data class RechargeFact(
    /**
     * The recharge time in seconds.
     */
    @Serializable(with = SecondDurationSerializer::class)
    @SerialName("value")
    val value: Duration = Duration.ZERO
) : TraitFact()