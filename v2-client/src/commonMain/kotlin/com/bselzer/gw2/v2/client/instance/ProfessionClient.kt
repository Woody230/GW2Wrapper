package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.model.profession.Profession
import com.bselzer.gw2.v2.model.profession.ProfessionId
import io.ktor.client.*

/**
 * The profession client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/professions">the wiki</a>
 */
class ProfessionClient(httpClient: HttpClient, configuration: DefaultGw2HttpOptions) : BaseClient(httpClient, configuration) {
    private companion object {
        const val PROFESSIONS = "professions"

    }

    /**
     * @return the ids of the available professions
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/professions">the wiki</a>
     */
    suspend fun ids(): List<ProfessionId> = getList(path = PROFESSIONS)

    /**
     * @return the profession associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/professions">the wiki</a>
     */
    suspend fun profession(id: ProfessionId, language: Language? = null): Profession = getSingleById(id, PROFESSIONS, instance = { Profession(id = it) }) {
        language(language)
    }

    /**
     * @return the professions associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/professions">the wiki</a>
     */
    suspend fun professions(ids: Collection<ProfessionId>, language: Language? = null): List<Profession> = chunkedIds(ids, PROFESSIONS, instance = { Profession(id = it) }) {
        language(language)
    }

    /**
     * @return all the professions
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/professions">the wiki</a>
     */
    suspend fun professions(language: Language? = null): List<Profession> = allIds(PROFESSIONS) {
        language(language)
    }
}