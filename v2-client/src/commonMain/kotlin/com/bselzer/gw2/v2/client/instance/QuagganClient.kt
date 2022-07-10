package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.request.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.model.quaggan.Quaggan
import com.bselzer.gw2.v2.model.quaggan.QuagganId
import io.ktor.client.*

/**
 * The quaggan client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quaggans">the wiki</a>
 */
class QuagganClient(httpClient: HttpClient, configuration: DefaultGw2HttpOptions) : BaseClient(httpClient, configuration) {
    private companion object {
        const val QUAGGANS = "quaggans"
    }

    /**
     * @return the ids of the available quaggans
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quaggans">the wiki</a>
     */
    suspend fun ids(): List<QuagganId> = getIds(path = QUAGGANS)

    /**
     * @return the quaggan associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quaggans">the wiki</a>
     */
    suspend fun quaggan(id: QuagganId): Quaggan = getSingleById(id, QUAGGANS, instance = { Quaggan(id = it) })

    /**
     * @return the quaggans associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quaggans">the wiki</a>
     */
    suspend fun quaggans(ids: Collection<QuagganId>): List<Quaggan> = chunkedIds(ids, QUAGGANS, instance = { Quaggan(id = it) })

    /**
     * @return all the quaggans
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quaggans">the wiki</a>
     */
    suspend fun quaggans(): List<Quaggan> = allIds(QUAGGANS)
}