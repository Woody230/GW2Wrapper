package com.bselzer.gw2.v2.model.account.currency

import com.bselzer.gw2.v2.model.currency.CurrencyId
import com.bselzer.gw2.v2.model.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountCurrency(
    /**
     * The id of the currency.
     * @see <a href="https://wiki.guildwars2.com/wiki/Currency">the wiki</a>
     */
    @SerialName("id")
    override val id: CurrencyId = CurrencyId(),

    /**
     * The amount of the currency.
     */
    @SerialName("value")
    val count: Int = 0
) : Identifiable<Int>