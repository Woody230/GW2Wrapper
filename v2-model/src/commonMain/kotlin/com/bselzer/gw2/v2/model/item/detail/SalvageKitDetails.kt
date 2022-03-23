package com.bselzer.gw2.v2.model.item.detail

import com.bselzer.gw2.v2.model.enumeration.wrapper.SalvageKitDetailType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SalvageKitDetails(
    @SerialName("type")
    val type: SalvageKitDetailType = SalvageKitDetailType(),

    /**
     * The number of charges left.
     */
    @SerialName("charges")
    val charges: Int = 0
)