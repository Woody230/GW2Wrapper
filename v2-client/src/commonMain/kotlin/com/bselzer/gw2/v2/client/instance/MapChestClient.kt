package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.request.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.model.mapchest.MapChestId
import io.ktor.client.*

/**
 * The map chests client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mapchests">the wiki</a>
 */
class MapChestClient(httpClient: HttpClient, configuration: DefaultGw2HttpOptions) : BaseClient(httpClient, configuration) {
    private companion object {
        const val MAP_CHESTS = "mapchests"
    }

    /**
     * @return the ids of the daily map chests
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mapchests>the wiki</a>
     */
    suspend fun ids(): List<MapChestId> = getIds(path = MAP_CHESTS)
}