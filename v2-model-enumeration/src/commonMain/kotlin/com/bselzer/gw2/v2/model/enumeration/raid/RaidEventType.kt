package com.bselzer.gw2.v2.model.enumeration.raid

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class RaidEventType {
    @SerialName("Checkpoint")
    CHECKPOINT,

    @SerialName("Boss")
    BOSS
}