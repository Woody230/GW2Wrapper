package com.bselzer.library.gw2.v2.client.client

import io.ktor.client.*

/**
 * The world boss client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worldbosses">the wiki</a>
 */
class WorldBossClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val WORLD_BOSSES = "worldbosses"
    }

    /**
     * @return the ids of the daily world bosses
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worldbosses">the wiki</a>
     */
    // TODO enum and extension method
    suspend fun ids(): List<String> = get(path = WORLD_BOSSES)
}