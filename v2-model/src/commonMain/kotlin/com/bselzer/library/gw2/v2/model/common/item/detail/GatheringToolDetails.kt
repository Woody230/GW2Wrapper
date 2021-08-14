package com.bselzer.library.gw2.v2.model.common.item.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GatheringToolDetails(
    @SerialName("type")
    val type: String = ""
)