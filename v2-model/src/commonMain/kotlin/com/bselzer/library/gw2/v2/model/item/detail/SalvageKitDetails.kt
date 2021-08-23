package com.bselzer.library.gw2.v2.model.item.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SalvageKitDetails(
    @SerialName("type")
    val type: String = "",

    /**
     * The number of charges left.
     */
    @SerialName("charges")
    val charges: Int = 0
)