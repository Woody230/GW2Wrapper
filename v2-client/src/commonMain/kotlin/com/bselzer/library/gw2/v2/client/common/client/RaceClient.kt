package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Races
import com.bselzer.library.gw2.v2.model.common.race.Race
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The race client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/races">the wiki</a.
 */
class RaceClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available races
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/races">the wiki</a>
     */
    suspend fun ids(): List<String> = httpClient.get(path = Races.RACES)

    /**
     * @return the race associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/races">the wiki</a>
     */
    suspend fun race(id: String): Race = single(id, Races.RACES)

    /**
     * @return the races associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/races">the wiki</a>
     */
    suspend fun races(ids: Collection<String>): List<Race> = chunkedIds(ids, Races.RACES)

    /**
     * @return all the races
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/races">the wiki</a>
     */
    suspend fun races(): List<Race> = allIds(Races.RACES)
}