package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.request.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.model.raid.Raid
import com.bselzer.gw2.v2.model.raid.RaidId
import io.ktor.client.*

/**
 * The raid client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/raids">the wiki</a>
 */
class RaidClient(httpClient: HttpClient, configuration: DefaultGw2HttpOptions) : BaseClient(httpClient, configuration) {
    private companion object {
        const val RAIDS = "raids"
    }

    /**
     * @return the ids of the available raids
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/raids">the wiki</a>
     */
    suspend fun ids(): List<RaidId> = getIds(path = RAIDS)

    /**
     * @return the raid associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/raids">the wiki</a>
     */
    suspend fun raid(id: RaidId, language: Language? = null): Raid = getSingleById(id, RAIDS, instance = { Raid(id = it) }) {
        language(language)
    }

    /**
     * @return the raids associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/raids">the wiki</a>
     */
    suspend fun raids(ids: Collection<RaidId>, language: Language? = null): List<Raid> = chunkedIds(ids, RAIDS, instance = { Raid(id = it) }) {
        language(language)
    }

    /**
     * @return all the raids
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/raids">the wiki</a>
     */
    suspend fun raids(language: Language? = null): List<Raid> = allIds(RAIDS) {
        language(language)
    }
}