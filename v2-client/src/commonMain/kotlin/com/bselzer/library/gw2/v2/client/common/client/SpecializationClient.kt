package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.specialization.Specialization
import io.ktor.client.*

/**
 * The specialization client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki</a>
 */
class SpecializationClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val SPECIALIZATIONS = "specializations"
    }

    /**
     * @return the ids of the available specializations
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki</a>
     */
    suspend fun ids(): List<Int> = get(path = SPECIALIZATIONS)

    /**
     * @return the specialization associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki</a>
     */
    suspend fun specialization(id: Int, language: String? = null): Specialization = single(id, SPECIALIZATIONS) {
        language(language)
    }

    /**
     * @return the specializations associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki</a>
     */
    suspend fun specializations(ids: Collection<Int>, language: String? = null): List<Specialization> = chunkedIds(ids, SPECIALIZATIONS) {
        language(language)
    }

    /**
     * @return all the specializations
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki</a>
     */
    suspend fun specializations(language: String? = null): List<Specialization> = allIds(SPECIALIZATIONS) {
        language(language)
    }
}