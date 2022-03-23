package com.bselzer.gw2.v2.model.item.detail

import com.bselzer.gw2.v2.model.value.GatheringToolDetailType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GatheringToolDetails(
    @SerialName("type")
    val type: GatheringToolDetailType = GatheringToolDetailType()
)