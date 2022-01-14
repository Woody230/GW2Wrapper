package com.bselzer.gw2.v2.model.item.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BagDetails(
    @SerialName("size")
    val count: Int = 0,

    /**
     * Whether this bag is invisible and prevents selling and sorting of its items.
     */
    @SerialName("no_sell_or_sort")
    val isInvisible: Boolean = false
)