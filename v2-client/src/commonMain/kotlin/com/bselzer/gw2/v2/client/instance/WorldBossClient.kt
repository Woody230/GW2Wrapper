package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.model.worldboss.WorldBossId
import io.ktor.client.*

/**
 * The world boss client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worldbosses">the wiki</a>
 */
class WorldBossClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val WORLD_BOSSES = "worldbosses"
    }

    /**
     * @return the ids of the daily world bosses
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worldbosses">the wiki</a>
     */
    suspend fun ids(): List<WorldBossId> = getIds(path = WORLD_BOSSES)
}