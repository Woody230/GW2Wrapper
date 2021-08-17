package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.currency.Currency
import io.ktor.client.*

/**
 * The currency client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/currencies">the wiki</a>
 */
class CurrencyClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val CURRENCIES = "currencies"
    }

    /**
     * @return the ids of the available currencies
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/currencies">the wiki</a>
     */
    suspend fun ids(): List<Int> = get(path = CURRENCIES)

    /**
     * @return the currency associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/currencies">the wiki</a>
     */
    suspend fun currency(id: Int, language: String? = null): Currency = single(id, CURRENCIES) {
        language(language)
    }

    /**
     * @return the currencies associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/currencies">the wiki</a>
     */
    suspend fun currencies(ids: Collection<Int>, language: String? = null): List<Currency> = chunkedIds(ids, CURRENCIES) {
        language(language)
    }

    /**
     * @return all the currencies
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/currencies">the wiki</a>
     */
    suspend fun currencies(language: String? = null): List<Currency> = allIds(CURRENCIES) {
        language(language)
    }
}