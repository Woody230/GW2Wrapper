package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.model.mastery.Mastery
import com.bselzer.gw2.v2.model.mastery.MasteryId
import io.ktor.client.*

/**
 * The mastery client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">the wiki</a>
 */
class MasteryClient(httpClient: HttpClient, configuration: DefaultGw2HttpOptions) : BaseClient(httpClient, configuration) {
    private companion object {
        const val MASTERIES = "masteries"
    }

    /**
     * @return the ids of the available masteries
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">the wiki</a>
     */
    suspend fun ids(): List<MasteryId> = getIds(path = MASTERIES)

    /**
     * @return the mastery associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">the wiki</a>
     */
    suspend fun mastery(id: MasteryId, language: Language? = null): Mastery = getSingleById(id, MASTERIES, instance = { Mastery(id = it) }) {
        language(language)
    }

    /**
     * @return the masteries associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">the wiki</a>
     */
    suspend fun masteries(ids: Collection<MasteryId>, language: Language? = null): List<Mastery> = chunkedIds(ids, MASTERIES, instance = { Mastery(id = it) }) {
        language(language)
    }

    /**
     * @return all the masteries
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">the wiki</a>
     */
    suspend fun masteries(language: Language? = null): List<Mastery> = allIds(MASTERIES) {
        language(language)
    }
}