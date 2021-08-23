package com.bselzer.library.gw2.v2.model.item

import com.bselzer.library.gw2.v2.model.item.detail.GatheringToolDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Gathering")
data class GatheringToolItem(
    @SerialName("details")
    val details: GatheringToolDetails = GatheringToolDetails()
) : Item()