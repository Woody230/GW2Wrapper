package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.model.mastery.Mastery
import io.ktor.client.*

/**
 * The mastery client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">the wiki</a>
 */
class MasteryClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val MASTERIES = "masteries"
    }

    /**
     * @return the ids of the available masteries
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">the wiki</a>
     */
    suspend fun ids(): List<Int> = getList(path = MASTERIES)

    /**
     * @return the mastery associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">the wiki</a>
     */
    suspend fun mastery(id: Int, language: String? = null): Mastery = getSingleById(id, MASTERIES) {
        language(language)
    }

    /**
     * @return the masteries associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">the wiki</a>
     */
    suspend fun masteries(ids: Collection<Int>, language: String? = null): List<Mastery> = chunkedIds(ids, MASTERIES) {
        language(language)
    }

    /**
     * @return all the masteries
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">the wiki</a>
     */
    suspend fun masteries(language: String? = null): List<Mastery> = allIds(MASTERIES) {
        language(language)
    }
}