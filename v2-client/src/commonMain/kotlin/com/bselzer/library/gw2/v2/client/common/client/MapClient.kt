package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Maps
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.map.Map
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The map client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/maps">the wiki</a>
 */
class MapClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available maps
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/maps">the wiki</a>
     */
    suspend fun ids(): List<Int> = httpClient.get(path = Maps.MAPS)

    /**
     * @return the map associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/maps">the wiki</a>
     */
    suspend fun map(id: Int, language: String? = null): Map = single(id, Maps.MAPS) {
        language(language)
    }

    /**
     * @return the maps associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/maps">the wiki</a>
     */
    suspend fun maps(ids: Collection<Int>, language: String? = null): List<Map> = chunkedIds(ids, Maps.MAPS) {
        language(language)
    }

    /**
     * @return all the maps
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/maps">the wiki</a>
     */
    suspend fun maps(language: String? = null): List<Map> = allIds(Maps.MAPS) {
        language(language)
    }
}