package com.bselzer.library.gw2.v2.model.common.item

import com.bselzer.library.gw2.v2.model.common.item.detail.BagDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Bag")
data class BagItem(
    @SerialName("details")
    val details: BagDetails = BagDetails()
) : Item()