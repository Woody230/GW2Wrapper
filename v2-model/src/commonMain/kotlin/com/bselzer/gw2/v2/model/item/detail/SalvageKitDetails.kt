package com.bselzer.gw2.v2.model.item.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SalvageKitDetails(
    @SerialName("type")
    val type: com.bselzer.gw2.v2.model.wrapper.SalvageKitDetailType = com.bselzer.gw2.v2.model.wrapper.SalvageKitDetailType(),

    /**
     * The number of charges left.
     */
    @SerialName("charges")
    val charges: Int = 0
)