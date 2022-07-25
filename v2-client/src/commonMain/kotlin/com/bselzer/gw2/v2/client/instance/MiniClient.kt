package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.request.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.model.mini.Mini
import com.bselzer.gw2.v2.model.mini.MiniId
import io.ktor.client.*

/**
 * The mini-pet client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/minis">the wiki</a>
 */
class MiniClient(httpClient: HttpClient, configuration: DefaultGw2HttpOptions) : BaseClient(httpClient, configuration) {
    private companion object {
        const val MINIS = "minis"
    }

    /**
     * @return the ids of the available minis
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/minis">the wiki</a>
     */
    suspend fun ids(): List<MiniId> = getIds(path = MINIS)

    /**
     * @return the minis associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/minis">the wiki</a>
     */
    suspend fun minis(ids: Collection<MiniId>, language: Language? = null): List<Mini> = chunkedIds(ids, MINIS, instance = { Mini(id = it) }) {
        language(language)
    }

    /**
     * @return all the minis
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/minis">the wiki</a>
     */
    suspend fun minis(language: Language? = null): List<Mini> = allIds(MINIS) {
        language(language)
    }
}