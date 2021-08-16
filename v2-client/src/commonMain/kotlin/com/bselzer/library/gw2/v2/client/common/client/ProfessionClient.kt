package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Professions
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.profession.Profession
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The profession client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/professions">the wiki</a>
 */
class ProfessionClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available professions
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/professions">the wiki</a>
     */
    suspend fun ids(): List<String> = httpClient.get(path = Professions.PROFESSIONS)

    /**
     * @return the profession associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/professions">the wiki</a>
     */
    suspend fun profession(id: String, language: String? = null): Profession = single(id, Professions.PROFESSIONS) {
        language(language)
    }

    /**
     * @return the professions associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/professions">the wiki</a>
     */
    suspend fun professions(ids: Collection<String>, language: String? = null): List<Profession> = chunkedIds(ids, Professions.PROFESSIONS) {
        language(language)
    }

    /**
     * @return all the professions
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/professions">the wiki</a>
     */
    suspend fun professions(language: String? = null): List<Profession> = allIds(Professions.PROFESSIONS) {
        language(language)
    }
}