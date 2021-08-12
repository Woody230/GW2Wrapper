package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Titles
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.title.Title
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The title client.
 * <a href="https://wiki.guildwars2.com/wiki/API:2/titles">the wiki</a>
 */
class TitleClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available titles
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/titles">the wiki</a>
     */
    suspend fun ids(): List<Int> = httpClient.get(path = Titles.TITLES)

    /**
     * @return the titles associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/titles">the wiki</a>
     */
    suspend fun titles(ids: Collection<Int>, language: String? = null): List<Title> = chunkedIds(ids, Titles.TITLES) {
        language(language)
    }

    /**
     * @return all the titles
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/titles">the wiki</a>
     */
    suspend fun titles(language: String? = null): List<Title> = allIds(Titles.TITLES) {
        language(language)
    }
}