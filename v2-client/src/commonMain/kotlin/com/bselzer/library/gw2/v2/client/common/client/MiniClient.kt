package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Minis
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.mini.Mini
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The mini-pet client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/minis">the wiki</a>
 */
class MiniClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available minis
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/minis">the wiki</a>
     */
    suspend fun ids(): List<Int> = httpClient.get(path = Minis.MINIS)

    /**
     * @return the minis associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/minis">the wiki</a>
     */
    suspend fun minis(ids: Collection<Int>, language: String? = null): List<Mini> = chunkedIds(ids, Minis.MINIS) {
        language(language)
    }

    /**
     * @return all the minis
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/minis">the wiki</a>
     */
    suspend fun minis(language: String? = null): List<Mini> = allIds(Minis.MINIS) {
        language(language)
    }
}