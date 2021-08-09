package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.WorldBosses
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The world boss client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worldbosses">the wiki</a>
 */
class WorldBossClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the daily world bosses
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worldbosses">the wiki</a>
     */
    // TODO enum and extension method
    suspend fun ids(): List<String> = httpClient.get(path = WorldBosses.WORLD_BOSSES)
}