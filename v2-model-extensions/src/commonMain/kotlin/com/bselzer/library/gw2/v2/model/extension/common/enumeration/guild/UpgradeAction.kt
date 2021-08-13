package com.bselzer.library.gw2.v2.model.extension.common.enumeration.guild

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class UpgradeAction
{
    @SerialName("queued")
    QUEUED,

    @SerialName("cancelled")
    CANCELLED,

    @SerialName("completed")
    COMPLETED,

    @SerialName("sped_up")
    SPED_UP
}