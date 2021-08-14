package com.bselzer.library.gw2.v2.model.common.item

import com.bselzer.library.gw2.v2.model.common.item.detail.ConsumableDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Consumable")
data class ConsumableItem(
    @SerialName("details")
    val details: ConsumableDetails = ConsumableDetails()
) : Item()