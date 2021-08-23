package com.bselzer.library.gw2.v2.client.client

import com.bselzer.library.gw2.v2.client.extension.language
import com.bselzer.library.gw2.v2.model.title.Title
import io.ktor.client.*

/**
 * The title client.
 * <a href="https://wiki.guildwars2.com/wiki/API:2/titles">the wiki</a>
 */
class TitleClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val TITLES = "titles"
    }

    /**
     * @return the ids of the available titles
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/titles">the wiki</a>
     */
    suspend fun ids(): List<Int> = get(path = TITLES)

    /**
     * @return the title associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/titles">the wiki</a>
     */
    suspend fun title(id: Int, language: String? = null): Title = single(id, TITLES) {
        language(language)
    }

    /**
     * @return the titles associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/titles">the wiki</a>
     */
    suspend fun titles(ids: Collection<Int>, language: String? = null): List<Title> = chunkedIds(ids, TITLES) {
        language(language)
    }

    /**
     * @return all the titles
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/titles">the wiki</a>
     */
    suspend fun titles(language: String? = null): List<Title> = allIds(TITLES) {
        language(language)
    }
}