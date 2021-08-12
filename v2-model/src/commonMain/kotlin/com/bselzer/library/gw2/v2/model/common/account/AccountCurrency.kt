package com.bselzer.library.gw2.v2.model.common.account

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountCurrency(
    /**
     * The id of the currency.
     * @see <a href="https://wiki.guildwars2.com/wiki/Currency">the wiki</a>
     */
    @SerialName("id")
    val id: Int = 0,

    /**
     * The amount of the currency.
     */
    @SerialName("value")
    val count: Int = 0
)