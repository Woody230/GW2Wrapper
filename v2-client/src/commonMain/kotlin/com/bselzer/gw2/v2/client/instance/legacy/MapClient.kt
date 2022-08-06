package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.model.map.Map
import com.bselzer.gw2.v2.model.map.MapId
import io.ktor.client.*

/**
 * The map client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/maps">the wiki</a>
 */
class MapClient(httpClient: HttpClient, configuration: DefaultGw2HttpOptions) : BaseClient(httpClient, configuration) {
    private companion object {
        const val MAPS = "maps"
    }

    /**
     * @return the ids of the available maps
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/maps">the wiki</a>
     */
    suspend fun ids(): List<MapId> = getIds(path = MAPS)

    /**
     * @return the map associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/maps">the wiki</a>
     */
    suspend fun map(id: MapId, language: Language? = null): Map = getSingleById(id, MAPS, instance = { Map(id = it) }) {
        language(language)
    }

    /**
     * @return the maps associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/maps">the wiki</a>
     */
    suspend fun maps(ids: Collection<MapId>, language: Language? = null): List<Map> = chunkedIds(ids, MAPS, instance = { Map(id = it) }) {
        language(language)
    }

    /**
     * @return all the maps
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/maps">the wiki</a>
     */
    suspend fun maps(language: Language? = null): List<Map> = allIds(MAPS) {
        language(language)
    }
}