package com.bselzer.library.gw2.v2.model.item

import com.bselzer.library.gw2.v2.model.item.detail.SalvageKitDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Tool")
data class SalvageKitItem(
    @SerialName("details")
    val details: SalvageKitDetails = SalvageKitDetails()
) : Item()