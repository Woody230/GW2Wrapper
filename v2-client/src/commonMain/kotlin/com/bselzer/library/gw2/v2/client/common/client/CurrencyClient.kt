package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Currencies
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.currency.Currency
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The currency client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/currencies">the wiki</a>
 */
class CurrencyClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available currencies
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/currencies">the wiki</a>
     */
    suspend fun ids(): List<Int> = httpClient.get(path = Currencies.CURRENCIES)

    /**
     * @return the currencies associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/currencies">the wiki</a>
     */
    suspend fun currencies(ids: Collection<Int>, language: String? = null): List<Currency> = chunkedIds(ids, Currencies.CURRENCIES) {
        language(language)
    }

    /**
     * @return all the currencies
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/currencies">the wiki</a>
     */
    suspend fun currencies(language: String? = null): List<Currency> = allIds(Currencies.CURRENCIES) {
        language(language)
    }
}