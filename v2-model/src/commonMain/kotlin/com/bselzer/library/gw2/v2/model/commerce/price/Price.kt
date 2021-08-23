package com.bselzer.library.gw2.v2.model.commerce.price

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Price(
    /**
     * The highest buy order or the lowest sell offer in copper coins.
     */
    @SerialName("unit_price")
    val unitPrice: Int = 0,

    /**
     * The number of items being bought or sold.
     */
    @SerialName("quantity")
    val count: Int = 0
)