package com.bselzer.library.gw2.v2.model.common.item

import com.bselzer.library.gw2.v2.model.common.item.detail.MiniDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("MiniPet")
data class MiniItem(
    @SerialName("details")
    val details: MiniDetails = MiniDetails()
) : Item()