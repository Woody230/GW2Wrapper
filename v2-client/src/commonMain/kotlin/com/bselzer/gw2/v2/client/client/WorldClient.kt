package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.model.Language
import com.bselzer.gw2.v2.model.world.World
import com.bselzer.gw2.v2.model.world.WorldId
import io.ktor.client.*

/**
 * The world client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">the wiki</a>
 */
class WorldClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val WORLDS = "worlds"
    }

    /**
     * @return the ids of the available worlds
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">the wiki</a>
     */
    suspend fun ids(): List<WorldId> = getIds(path = WORLDS)

    /**
     * @return the world associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">the wiki</a>
     */
    suspend fun world(id: WorldId, language: Language? = null): World = getSingleById(id, WORLDS, instance = { World(id = it) }) {
        language(language)
    }

    /**
     * @return the worlds associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">the wiki</a>
     */
    suspend fun worlds(ids: Collection<WorldId>, language: Language? = null): List<World> = chunkedIds(ids, WORLDS, instance = { World(id = it) }) {
        language(language)
    }

    /**
     * @return all the worlds
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">the wiki</a>
     */
    suspend fun worlds(language: Language? = null): List<World> = allIds(WORLDS) {
        language(language)
    }
}