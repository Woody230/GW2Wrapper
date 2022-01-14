package com.bselzer.gw2.v2.model.item

import com.bselzer.gw2.v2.model.item.detail.MiniDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("MiniPet")
data class MiniItem(
    @SerialName("details")
    val details: MiniDetails = MiniDetails()
) : Item()