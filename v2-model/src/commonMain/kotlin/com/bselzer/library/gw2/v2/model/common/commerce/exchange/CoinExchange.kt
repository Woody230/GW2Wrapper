package com.bselzer.library.gw2.v2.model.common.commerce.exchange

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinExchange(
    /**
     * The number of coins required for a single gem.
     */
    @SerialName("coins_per_gem")
    val coinsPerGem: Int = 0,

    /**
     * The number of gems obtained in exchange for the specified quantity of coins.
     */
    @SerialName("quantity")
    val count: Int = 0
)