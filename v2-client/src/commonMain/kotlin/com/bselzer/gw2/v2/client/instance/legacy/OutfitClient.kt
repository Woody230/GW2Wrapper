package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.model.outfit.Outfit
import com.bselzer.gw2.v2.model.outfit.OutfitId
import io.ktor.client.*

/**
 * The outfit client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/outfits">the wiki</a>
 */
class OutfitClient(httpClient: HttpClient, configuration: DefaultGw2HttpOptions) : BaseClient(httpClient, configuration) {
    private companion object {
        const val OUTFITS = "outfits"
    }

    /**
     * @return the ids of the available outfits
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/outfits">the wiki</a>
     */
    suspend fun ids(): List<OutfitId> = getIds(path = OUTFITS)

    /**
     * @return the outfit associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/outfits">the wiki</a>
     */
    suspend fun outfit(id: OutfitId, language: Language? = null): Outfit = getSingleById(id, OUTFITS, instance = { Outfit(id = it) }) {
        language(language)
    }

    /**
     * @return the outfits associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/outfits">the wiki</a>
     */
    suspend fun outfits(ids: Collection<OutfitId>, language: Language? = null): List<Outfit> = chunkedIds(ids, OUTFITS, instance = { Outfit(id = it) }) {
        language(language)
    }

    /**
     * @return all the outfits
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/outfits">the wiki</a>
     */
    suspend fun outfits(language: Language? = null): List<Outfit> = allIds(OUTFITS) {
        language(language)
    }
}