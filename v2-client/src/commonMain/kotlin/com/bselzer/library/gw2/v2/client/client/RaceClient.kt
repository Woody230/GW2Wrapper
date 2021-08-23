package com.bselzer.library.gw2.v2.client.client

import com.bselzer.library.gw2.v2.model.race.Race
import io.ktor.client.*

/**
 * The race client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/races">the wiki</a.
 */
class RaceClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val RACES = "races"
    }

    /**
     * @return the ids of the available races
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/races">the wiki</a>
     */
    suspend fun ids(): List<String> = get(path = RACES)

    /**
     * @return the race associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/races">the wiki</a>
     */
    suspend fun race(id: String): Race = single(id, RACES)

    /**
     * @return the races associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/races">the wiki</a>
     */
    suspend fun races(ids: Collection<String>): List<Race> = chunkedIds(ids, RACES)

    /**
     * @return all the races
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/races">the wiki</a>
     */
    suspend fun races(): List<Race> = allIds(RACES)
}