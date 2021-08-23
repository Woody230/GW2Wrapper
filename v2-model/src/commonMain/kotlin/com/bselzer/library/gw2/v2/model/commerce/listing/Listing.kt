package com.bselzer.library.gw2.v2.model.commerce.listing

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Listing(
    /**
     * The number of individual listings this object refers to.
     *
     * For example, two players selling at the same price will use the same listing.
     */
    @SerialName("listings")
    val listings: Int = 0,

    /**
     * The sell offer or buy order price in copper coins.
     */
    @SerialName("unit_price")
    val unitPrice: Int = 0,

    /**
     * The number of items being bought or sold.
     */
    @SerialName("quantity")
    val count: Int = 0
)