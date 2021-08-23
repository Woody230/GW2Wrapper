package com.bselzer.library.gw2.v2.client.client

import com.bselzer.library.gw2.v2.client.extension.language
import com.bselzer.library.gw2.v2.model.skin.Skin
import io.ktor.client.*

/**
 * The skin client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skins">the wiki</a>
 */
class SkinClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val SKINS = "skins"
    }

    /**
     * @return the ids of the available skins
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skins">the wiki</a>
     */
    suspend fun ids(): List<Int> = get(path = SKINS)

    /**
     * @return the skin associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skins">the wiki</a>
     */
    suspend fun skin(id: Int, language: String? = null): Skin = single(id, SKINS) {
        language(language)
    }

    /**
     * @return the skins associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skins">the wiki</a>
     */
    suspend fun skins(ids: Collection<Int>, language: String? = null): List<Skin> = chunkedIds(ids, SKINS) {
        language(language)
    }
}