package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Raids
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.raid.Raid
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The raid client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/raids">the wiki</a>
 */
class RaidClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available raids
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/raids">the wiki</a>
     */
    suspend fun ids(): List<String> = httpClient.get(path = Raids.RAIDS)

    /**
     * @return the raid associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/raids">the wiki</a>
     */
    suspend fun raid(id: String, language: String? = null): Raid = single(id, Raids.RAIDS) {
        language(language)
    }

    /**
     * @return the raids associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/raids">the wiki</a>
     */
    suspend fun raids(ids: Collection<String>, language: String? = null): List<Raid> = chunkedIds(ids, Raids.RAIDS) {
        language(language)
    }

    /**
     * @return all the raids
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/raids">the wiki</a>
     */
    suspend fun raids(language: String? = null): List<Raid> = allIds(Raids.RAIDS) {
        language(language)
    }
}