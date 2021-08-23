package com.bselzer.library.gw2.v2.model.achievement.daily

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyLevel(
    /**
     * The minimum level requirement.
     */
    @SerialName("min")
    val minimum: Int = 0,

    /**
     * The maximum level requirement.
     */
    @SerialName("max")
    val maximum: Int = 0
)