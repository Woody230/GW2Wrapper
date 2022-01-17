package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.model.finisher.Finisher
import io.ktor.client.*

/**
 * The finisher client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">the wiki</a>
 */
class FinisherClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val FINISHERS = "finishers"
    }

    /**
     * @return the ids of the available finishers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">the wiki</a>
     */
    suspend fun ids(): List<Int> = getList(path = FINISHERS)

    /**
     * @return the finisher associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">the wiki</a>
     */
    suspend fun finisher(id: Int, language: String? = null): Finisher = getSingleById(id, FINISHERS, instance = { Finisher(id = it) }) {
        language(language)
    }

    /**
     * @return the finishers associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">the wiki</a>
     */
    suspend fun finishers(ids: Collection<Int>, language: String? = null): List<Finisher> = chunkedIds(ids, FINISHERS, instance = { Finisher(id = it) }) {
        language(language)
    }

    /**
     * @return all the finishers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">the wiki</a>
     */
    suspend fun finishers(language: String? = null): List<Finisher> = allIds(FINISHERS) {
        language(language)
    }
}