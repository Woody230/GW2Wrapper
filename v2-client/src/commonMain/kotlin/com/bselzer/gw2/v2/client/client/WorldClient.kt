package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.model.world.World
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
    suspend fun ids(): List<Int> = getList(path = WORLDS)

    /**
     * @return the world associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">the wiki</a>
     */
    suspend fun world(id: Int, language: String? = null): List<World> = getSingleById(id, WORLDS) {
        language(language)
    }

    /**
     * @return the worlds associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">the wiki</a>
     */
    suspend fun worlds(ids: Collection<Int>, language: String? = null): List<World> = chunkedIds(ids, WORLDS) {
        language(language)
    }

    /**
     * @return all the worlds
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">the wiki</a>
     */
    suspend fun worlds(language: String? = null): List<World> = allIds(WORLDS) {
        language(language)
    }
}