package com.bselzer.library.gw2.v2.model.common.skin.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GatheringToolSkinDetails(
    @SerialName("type")
    val type: String = ""
)