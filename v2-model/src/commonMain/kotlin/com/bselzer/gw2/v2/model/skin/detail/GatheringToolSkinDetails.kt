package com.bselzer.gw2.v2.model.skin.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GatheringToolSkinDetails(
    @SerialName("type")
    val type: com.bselzer.gw2.v2.model.wrapper.GatheringToolDetailType = com.bselzer.gw2.v2.model.wrapper.GatheringToolDetailType()
)