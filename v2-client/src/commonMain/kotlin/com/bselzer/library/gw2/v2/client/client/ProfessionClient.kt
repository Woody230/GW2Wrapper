package com.bselzer.library.gw2.v2.client.client

import com.bselzer.library.gw2.v2.client.extension.language
import com.bselzer.library.gw2.v2.model.profession.Profession
import io.ktor.client.*

/**
 * The profession client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/professions">the wiki</a>
 */
class ProfessionClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val PROFESSIONS = "professions"

    }

    /**
     * @return the ids of the available professions
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/professions">the wiki</a>
     */
    suspend fun ids(): List<String> = getList(path = PROFESSIONS)

    /**
     * @return the profession associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/professions">the wiki</a>
     */
    suspend fun profession(id: String, language: String? = null): Profession = getSingleById(id, PROFESSIONS) {
        language(language)
    }

    /**
     * @return the professions associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/professions">the wiki</a>
     */
    suspend fun professions(ids: Collection<String>, language: String? = null): List<Profession> = chunkedIds(ids, PROFESSIONS) {
        language(language)
    }

    /**
     * @return all the professions
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/professions">the wiki</a>
     */
    suspend fun professions(language: String? = null): List<Profession> = allIds(PROFESSIONS) {
        language(language)
    }
}