package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Masteries
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.mastery.Mastery
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The mastery client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">the wiki</a>
 */
class MasteryClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available masteries
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">the wiki</a>
     */
    suspend fun ids(): List<Int> = httpClient.get(path = Masteries.MASTERIES)

    /**
     * @return the masteries associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">the wiki</a>
     */
    suspend fun masteries(ids: Collection<Int>, language: String? = null): List<Mastery> = chunkedIds(ids, Masteries.MASTERIES) {
        language(language)
    }

    /**
     * @return all the masteries
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">the wiki</a>
     */
    suspend fun masteries(language: String? = null): List<Mastery> = allIds(Masteries.MASTERIES) {
        language(language)
    }
}