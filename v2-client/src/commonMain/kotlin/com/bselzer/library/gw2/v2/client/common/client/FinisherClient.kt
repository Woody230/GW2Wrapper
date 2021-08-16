package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Finishers
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.finisher.Finisher
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The finisher client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">the wiki</a>
 */
class FinisherClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available finishers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">the wiki</a>
     */
    suspend fun ids(): List<Int> = httpClient.get(path = Finishers.FINISHERS)

    /**
     * @return the finisher associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">the wiki</a>
     */
    suspend fun finisher(id: Int, language: String? = null): Finisher = single(id, Finishers.FINISHERS) {
        language(language)
    }

    /**
     * @return the finishers associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">the wiki</a>
     */
    suspend fun finishers(ids: Collection<Int>, language: String? = null): List<Finisher> = chunkedIds(ids, Finishers.FINISHERS) {
        language(language)
    }

    /**
     * @return all the finishers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">the wiki</a>
     */
    suspend fun finishers(language: String? = null): List<Finisher> = allIds(Finishers.FINISHERS) {
        language(language)
    }
}