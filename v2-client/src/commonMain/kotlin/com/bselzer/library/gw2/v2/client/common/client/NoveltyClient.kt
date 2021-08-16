package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Novelties
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.novelty.Novelty
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The novelty client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/novelties">the wiki</a>
 */
class NoveltyClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available novelties
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/novelties">the wiki</a>
     */
    suspend fun ids(): List<Int> = httpClient.get(path = Novelties.NOVELTIES)

    /**
     * @return the novelty associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/novelties">the wiki</a>
     */
    suspend fun novelty(id: Int, language: String? = null): Novelty = single(id, Novelties.NOVELTIES) {
        language(language)
    }

    /**
     * @return the novelties associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/novelties">the wiki</a>
     */
    suspend fun novelties(ids: Collection<Int>, language: String? = null): List<Novelty> = chunkedIds(ids, Novelties.NOVELTIES) {
        language(language)
    }

    /**
     * @return all the novelties
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/novelties">the wiki</a>
     */
    suspend fun novelties(language: String? = null): List<Novelty> = allIds(Novelties.NOVELTIES) {
        language(language)
    }
}