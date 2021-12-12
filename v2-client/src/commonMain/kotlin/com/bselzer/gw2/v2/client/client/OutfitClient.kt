package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.model.outfit.Outfit
import io.ktor.client.*

/**
 * The outfit client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/outfits">the wiki</a>
 */
class OutfitClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val OUTFITS = "outfits"
    }

    /**
     * @return the ids of the available outfits
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/outfits">the wiki</a>
     */
    suspend fun ids(): List<Int> = getList(path = OUTFITS)

    /**
     * @return the outfit associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/outfits">the wiki</a>
     */
    suspend fun outfit(id: Int, language: String? = null): Outfit = getSingleById(id, OUTFITS) {
        language(language)
    }

    /**
     * @return the outfits associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/outfits">the wiki</a>
     */
    suspend fun outfits(ids: Collection<Int>, language: String? = null): List<Outfit> = chunkedIds(ids, OUTFITS) {
        language(language)
    }

    /**
     * @return all the outfits
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/outfits">the wiki</a>
     */
    suspend fun outfits(language: String? = null): List<Outfit> = allIds(OUTFITS) {
        language(language)
    }
}