package com.bselzer.gw2.v2.model.item

import com.bselzer.gw2.v2.model.item.detail.BagDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Bag")
data class BagItem(
    @SerialName("details")
    val details: BagDetails = BagDetails()
) : Item()