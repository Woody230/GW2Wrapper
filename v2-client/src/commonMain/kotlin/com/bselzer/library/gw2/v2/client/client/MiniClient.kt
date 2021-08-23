package com.bselzer.library.gw2.v2.client.client

import com.bselzer.library.gw2.v2.client.extension.language
import com.bselzer.library.gw2.v2.model.mini.Mini
import io.ktor.client.*

/**
 * The mini-pet client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/minis">the wiki</a>
 */
class MiniClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val MINIS = "minis"
    }

    /**
     * @return the ids of the available minis
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/minis">the wiki</a>
     */
    suspend fun ids(): List<Int> = get(path = MINIS)

    /**
     * @return the minis associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/minis">the wiki</a>
     */
    suspend fun minis(ids: Collection<Int>, language: String? = null): List<Mini> = chunkedIds(ids, MINIS) {
        language(language)
    }

    /**
     * @return all the minis
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/minis">the wiki</a>
     */
    suspend fun minis(language: String? = null): List<Mini> = allIds(MINIS) {
        language(language)
    }
}