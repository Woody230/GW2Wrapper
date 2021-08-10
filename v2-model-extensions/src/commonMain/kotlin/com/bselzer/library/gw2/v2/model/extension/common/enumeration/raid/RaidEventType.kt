package com.bselzer.library.gw2.v2.model.extension.common.enumeration.raid

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class RaidEventType
{
    @SerialName("Checkpoint")
    CHECKPOINT,

    @SerialName("Boss")
    BOSS
}