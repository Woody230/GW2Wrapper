package com.bselzer.gw2.v2.client.client

import io.ktor.client.*

/**
 * The map chests client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mapchests">the wiki</a>
 */
class MapChestClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val MAP_CHESTS = "mapchests"
    }

    /**
     * @return the ids of the daily map chests
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mapchests>the wiki</a>
     */
    // TODO enum and extension method
    suspend fun ids(): List<String> = getList(path = MAP_CHESTS)
}