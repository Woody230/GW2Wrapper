package com.bselzer.library.gw2.v2.model.commerce.exchange

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GemExchange(
    /**
     * The number of coins obtained for a single gem.
     */
    @SerialName("coins_per_gem")
    val coinsPerGem: Int = 0,

    /**
     * The number of coins obtained in exchange for the specified quantity of gems.
     */
    @SerialName("quantity")
    val count: Int = 0
)