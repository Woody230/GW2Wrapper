package com.bselzer.library.gw2.v2.model.common.raid

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Raid(
    /**
     * The name of the dungeon.
     */
    // TODO enum and extension
    @SerialName("id")
    val id: String = "",

    @SerialName("wings")
    val wings: List<RaidWing> = emptyList()
)