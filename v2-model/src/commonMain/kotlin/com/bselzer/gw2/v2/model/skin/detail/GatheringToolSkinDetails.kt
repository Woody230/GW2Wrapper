package com.bselzer.gw2.v2.model.skin.detail

import com.bselzer.gw2.v2.model.wrapper.GatheringToolDetailType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GatheringToolSkinDetails(
    @SerialName("type")
    val type: GatheringToolDetailType = GatheringToolDetailType()
)