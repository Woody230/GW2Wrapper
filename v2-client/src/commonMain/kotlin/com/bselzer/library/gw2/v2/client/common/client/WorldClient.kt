package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Worlds
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.world.World
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The world client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">the wiki</a>
 */
class WorldClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available worlds
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">the wiki</a>
     */
    suspend fun ids(): List<Int> = httpClient.get(path = Worlds.WORLDS)

    /**
     * @return the world associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">the wiki</a>
     */
    suspend fun world(id: Int, language: String? = null): List<World> = single(id, Worlds.WORLDS) {
        language(language)
    }

    /**
     * @return the worlds associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">the wiki</a>
     */
    suspend fun worlds(ids: Collection<Int>, language: String? = null): List<World> = chunkedIds(ids, Worlds.WORLDS) {
        language(language)
    }

    /**
     * @return all the worlds
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">the wiki</a>
     */
    suspend fun worlds(language: String? = null): List<World> = allIds(Worlds.WORLDS) {
        language(language)
    }
}