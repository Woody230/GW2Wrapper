package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.model.Language
import com.bselzer.gw2.v2.model.novelty.Novelty
import com.bselzer.gw2.v2.model.novelty.NoveltyId
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
    suspend fun ids(): List<NoveltyId> = getIds(path = NOVELTIES)

    /**
     * @return the novelty associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/novelties">the wiki</a>
     */
    suspend fun novelty(id: NoveltyId, language: Language? = null): Novelty = getSingleById(id, NOVELTIES, instance = { Novelty(id = it) }) {
        language(language)
    }

    /**
     * @return the novelties associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/novelties">the wiki</a>
     */
    suspend fun novelties(ids: Collection<NoveltyId>, language: Language? = null): List<Novelty> = chunkedIds(ids, NOVELTIES, instance = { Novelty(id = it) }) {
        language(language)
    }

    /**
     * @return all the novelties
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/novelties">the wiki</a>
     */
    suspend fun novelties(language: Language? = null): List<Novelty> = allIds(NOVELTIES) {
        language(language)
    }
}