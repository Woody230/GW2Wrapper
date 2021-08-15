package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Skins
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.skin.Skin
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The skin client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skins">the wiki</a>
 */
class SkinClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available skins
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skins">the wiki</a>
     */
    suspend fun ids(): List<Int> = httpClient.get(path = Skins.SKINS)

    /**
     * @return the skins associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skins">the wiki</a>
     */
    suspend fun skins(ids: Collection<Int>, language: String? = null): List<Skin> = chunkedIds(ids, Skins.SKINS) {
        language(language)
    }
}