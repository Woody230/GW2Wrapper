package com.bselzer.library.gw2.v2.model.common.raid

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RaidWing(
    /**
     * The name of the dungeon path.
     */
    // TODO enum and extension
    @SerialName("id")
    val id: String = "",

    @SerialName("events")
    val events: List<RaidEvent> = emptyList()
)