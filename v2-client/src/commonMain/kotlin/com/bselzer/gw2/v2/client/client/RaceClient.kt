package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.model.race.Race
import com.bselzer.gw2.v2.model.race.RaceId
import io.ktor.client.*

/**
 * The race client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/races">the wiki</a.
 */
class RaceClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val RACES = "races"
    }

    /**
     * @return the ids of the available races
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/races">the wiki</a>
     */
    suspend fun ids(): List<RaceId> = getIds(path = RACES)

    /**
     * @return the race associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/races">the wiki</a>
     */
    suspend fun race(id: RaceId): Race = getSingleById(id, RACES, instance = { Race(id = it) })

    /**
     * @return the races associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/races">the wiki</a>
     */
    suspend fun races(ids: Collection<RaceId>): List<Race> = chunkedIds(ids, RACES, instance = { Race(id = it) })

    /**
     * @return all the races
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/races">the wiki</a>
     */
    suspend fun races(): List<Race> = allIds(RACES)
}