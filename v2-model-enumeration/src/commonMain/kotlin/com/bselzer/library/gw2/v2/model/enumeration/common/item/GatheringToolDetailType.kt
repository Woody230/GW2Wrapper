package com.bselzer.library.gw2.v2.model.enumeration.common.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class GatheringToolDetailType
{
    @SerialName("Foraging")
    FORAGING_TOOL,

    @SerialName("Logging")
    LOGGING_TOOL,

    @SerialName("Mining")
    MINING_TOOL,
}