package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Quaggans
import com.bselzer.library.gw2.v2.model.common.quaggan.Quaggan
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The quaggan client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quaggans">the wiki</a>
 */
class QuagganClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available quaggans
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quaggans">the wiki</a>
     */
    suspend fun ids(): List<String> = httpClient.get(path = Quaggans.QUAGGANS)

    /**
     * @return the quaggan associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quaggans">the wiki</a>
     */
    suspend fun quaggan(id: String): Quaggan = single(id, Quaggans.QUAGGANS)

    /**
     * @return the quaggans associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quaggans">the wiki</a>
     */
    suspend fun quaggans(ids: Collection<String>): List<Quaggan> = chunkedIds(ids, Quaggans.QUAGGANS)

    /**
     * @return all the quaggans
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quaggans">the wiki</a>
     */
    suspend fun quaggans(): List<Quaggan> = allIds(Quaggans.QUAGGANS)
}