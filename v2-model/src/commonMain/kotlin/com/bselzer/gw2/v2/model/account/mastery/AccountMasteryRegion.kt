package com.bselzer.gw2.v2.model.account.mastery

import com.bselzer.gw2.v2.model.value.RegionType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountMasteryRegion(
    @SerialName("region")
    val name: RegionType = RegionType(),

    /**
     * The number of points sent in this region.
     */
    @SerialName("spent")
    val spent: Int = 0,

    /**
     * The number of points earned in this region.
     */
    @SerialName("earned")
    val earned: Int = 0
)