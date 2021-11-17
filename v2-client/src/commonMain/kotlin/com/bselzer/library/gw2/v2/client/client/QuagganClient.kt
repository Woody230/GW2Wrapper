package com.bselzer.library.gw2.v2.client.client

import com.bselzer.library.gw2.v2.model.quaggan.Quaggan
import io.ktor.client.*

/**
 * The quaggan client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quaggans">the wiki</a>
 */
class QuagganClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val QUAGGANS = "quaggans"
    }

    /**
     * @return the ids of the available quaggans
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quaggans">the wiki</a>
     */
    suspend fun ids(): List<String> = getList(path = QUAGGANS)

    /**
     * @return the quaggan associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quaggans">the wiki</a>
     */
    suspend fun quaggan(id: String): Quaggan = getSingleById(id, QUAGGANS)

    /**
     * @return the quaggans associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quaggans">the wiki</a>
     */
    suspend fun quaggans(ids: Collection<String>): List<Quaggan> = chunkedIds(ids, QUAGGANS)

    /**
     * @return all the quaggans
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quaggans">the wiki</a>
     */
    suspend fun quaggans(): List<Quaggan> = allIds(QUAGGANS)
}