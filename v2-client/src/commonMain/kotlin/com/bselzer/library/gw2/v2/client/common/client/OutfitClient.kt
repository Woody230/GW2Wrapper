package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Outfits
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.outfit.Outfit
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The outfit client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/outfits">the wiki</a>
 */
class OutfitClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available outfits
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/outfits">the wiki</a>
     */
    suspend fun ids(): List<Int> = httpClient.get(path = Outfits.OUTFITS)

    /**
     * @return the outfits associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/outfits">the wiki</a>
     */
    suspend fun outfits(ids: Collection<Int>, language: String? = null): List<Outfit> = chunkedIds(ids, Outfits.OUTFITS) {
        language(language)
    }

    /**
     * @return all the outfits
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/outfits">the wiki</a>
     */
    suspend fun outfits(language: String? = null): List<Outfit> = allIds(Outfits.OUTFITS) {
        language(language)
    }
}