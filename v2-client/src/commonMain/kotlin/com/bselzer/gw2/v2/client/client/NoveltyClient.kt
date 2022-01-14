package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.model.novelty.Novelty
import io.ktor.client.*

/**
 * The novelty client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/novelties">the wiki</a>
 */
class NoveltyClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val NOVELTIES = "novelties"
    }

    /**
     * @return the ids of the available novelties
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/novelties">the wiki</a>
     */
    suspend fun ids(): List<Int> = getList(path = NOVELTIES)

    /**
     * @return the novelty associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/novelties">the wiki</a>
     */
    suspend fun novelty(id: Int, language: String? = null): Novelty = getSingleById(id, NOVELTIES) {
        language(language)
    }

    /**
     * @return the novelties associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/novelties">the wiki</a>
     */
    suspend fun novelties(ids: Collection<Int>, language: String? = null): List<Novelty> = chunkedIds(ids, NOVELTIES) {
        language(language)
    }

    /**
     * @return all the novelties
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/novelties">the wiki</a>
     */
    suspend fun novelties(language: String? = null): List<Novelty> = allIds(NOVELTIES) {
        language(language)
    }
}