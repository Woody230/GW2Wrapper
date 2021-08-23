package com.bselzer.library.gw2.v2.model.item

import com.bselzer.library.gw2.v2.model.item.detail.TrinketDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Trinket")
data class TrinketItem(
    @SerialName("details")
    val details: TrinketDetails = TrinketDetails()
) : Item()