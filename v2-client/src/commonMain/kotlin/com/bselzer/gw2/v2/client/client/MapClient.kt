package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.model.map.Map
import io.ktor.client.*

/**
 * The map client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/maps">the wiki</a>
 */
class MapClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val MAPS = "maps"
    }

    /**
     * @return the ids of the available maps
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/maps">the wiki</a>
     */
    suspend fun ids(): List<Int> = getList(path = MAPS)

    /**
     * @return the map associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/maps">the wiki</a>
     */
    suspend fun map(id: Int, language: String? = null): Map = getSingleById(id, MAPS) {
        language(language)
    }

    /**
     * @return the maps associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/maps">the wiki</a>
     */
    suspend fun maps(ids: Collection<Int>, language: String? = null): List<Map> = chunkedIds(ids, MAPS) {
        language(language)
    }

    /**
     * @return all the maps
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/maps">the wiki</a>
     */
    suspend fun maps(language: String? = null): List<Map> = allIds(MAPS) {
        language(language)
    }
}