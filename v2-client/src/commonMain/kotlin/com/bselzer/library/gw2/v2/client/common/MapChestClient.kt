package com.bselzer.library.gw2.v2.client.common

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.MapChests
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The map chests client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mapchests">the wiki</a>
 */
class MapChestClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the daily map chests
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mapchests>the wiki</a>
     */
    // TODO enum and extension method
    suspend fun ids(): List<String> = httpClient.get(path = MapChests.MAP_CHESTS)
}