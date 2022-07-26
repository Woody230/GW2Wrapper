package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.model.glider.Glider
import com.bselzer.gw2.v2.model.glider.GliderId
import io.ktor.client.*

/**
 * The glider client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/gliders">the wiki</a>
 */
class GliderClient(httpClient: HttpClient, configuration: DefaultGw2HttpOptions) : BaseClient(httpClient, configuration) {
    private companion object {
        const val GLIDERS = "gliders"
    }

    /**
     * @return the ids of the available gliders
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/gliders">the wiki</a>
     */
    suspend fun ids(): List<GliderId> = getIds(path = GLIDERS)

    /**
     * @return the glider associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/gliders">the wiki</a>
     */
    suspend fun glider(id: GliderId, language: Language? = null): Glider = getSingleById(id, GLIDERS, instance = { Glider(id = it) }) {
        language(language)
    }

    /**
     * @return the gliders associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/gliders">the wiki</a>
     */
    suspend fun gliders(ids: Collection<GliderId>, language: Language? = null): List<Glider> = chunkedIds(ids, GLIDERS, instance = { Glider(id = it) }) {
        language(language)
    }

    /**
     * @return all the gliders
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/gliders">the wiki</a>
     */
    suspend fun gliders(language: Language? = null): List<Glider> = allIds(GLIDERS) {
        language(language)
    }
}