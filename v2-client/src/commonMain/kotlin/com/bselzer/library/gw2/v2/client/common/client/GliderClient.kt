package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.glider.Glider
import io.ktor.client.*

/**
 * The glider client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/gliders">the wiki</a>
 */
class GliderClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val GLIDERS = "gliders"
    }

    /**
     * @return the ids of the available gliders
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/gliders">the wiki</a>
     */
    suspend fun ids(): List<Int> = get(path = GLIDERS)

    /**
     * @return the glider associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/gliders">the wiki</a>
     */
    suspend fun glider(id: Int, language: String? = null): Glider = single(id, GLIDERS) {
        language(language)
    }

    /**
     * @return the gliders associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/gliders">the wiki</a>
     */
    suspend fun gliders(ids: Collection<Int>, language: String? = null): List<Glider> = chunkedIds(ids, GLIDERS) {
        language(language)
    }

    /**
     * @return all the gliders
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/gliders">the wiki</a>
     */
    suspend fun gliders(language: String? = null): List<Glider> = allIds(GLIDERS) {
        language(language)
    }
}