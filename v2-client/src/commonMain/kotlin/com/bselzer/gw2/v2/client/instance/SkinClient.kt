package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.request.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.model.skin.DefaultSkin
import com.bselzer.gw2.v2.model.skin.Skin
import com.bselzer.gw2.v2.model.skin.SkinId
import io.ktor.client.*

/**
 * The skin client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skins">the wiki</a>
 */
class SkinClient(httpClient: HttpClient, configuration: DefaultGw2HttpOptions) : BaseClient(httpClient, configuration) {
    private companion object {
        const val SKINS = "skins"
    }

    /**
     * @return the ids of the available skins
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skins">the wiki</a>
     */
    suspend fun ids(): List<SkinId> = getIds(path = SKINS)

    /**
     * @return the skin associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skins">the wiki</a>
     */
    suspend fun skin(id: SkinId, language: Language? = null): Skin = getSingleById(id, SKINS, instance = { DefaultSkin(identifier = it) }) {
        language(language)
    }

    /**
     * @return the skins associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skins">the wiki</a>
     */
    suspend fun skins(ids: Collection<SkinId>, language: Language? = null): List<Skin> = chunkedIds(ids, SKINS, instance = { DefaultSkin(identifier = it) }) {
        language(language)
    }
}