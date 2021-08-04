package com.bselzer.library.gw2.v2.model.common.account.mastery

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountMasteryRegion(
    @SerialName("region")
    val name: String = "",

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