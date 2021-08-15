package com.bselzer.library.gw2.v2.model.common.skin

import com.bselzer.library.gw2.v2.model.common.item.detail.GatheringToolDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Gathering")
data class GatheringToolSkin(
    @SerialName("details")
    val details: GatheringToolDetails = GatheringToolDetails()
) : Skin()