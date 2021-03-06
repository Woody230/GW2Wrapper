package com.bselzer.gw2.v2.model.item

import com.bselzer.gw2.v2.model.item.detail.ConsumableDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Consumable")
data class ConsumableItem(
    @SerialName("details")
    val details: ConsumableDetails = ConsumableDetails()
) : Item()