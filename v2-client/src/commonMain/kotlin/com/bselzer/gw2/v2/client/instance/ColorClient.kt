package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.model.Language
import com.bselzer.gw2.v2.model.color.DyeColor
import com.bselzer.gw2.v2.model.color.DyeColorId
import io.ktor.client.*

/**
 * The color client for dyes.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
 */
class ColorClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val COLORS = "colors"
    }

    /**
     * @return the ids of the available dye colors
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    suspend fun ids(): List<DyeColorId> = getIds(path = COLORS)

    /**
     * @return the dye color associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    suspend fun color(id: DyeColorId, language: Language? = null): DyeColor = getSingleById(id, COLORS, instance = { DyeColor(id = it) }) {
        language(language)
    }

    /**
     * @return the dye colors associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    suspend fun colors(ids: Collection<DyeColorId>, language: Language? = null): List<DyeColor> = chunkedIds(ids, COLORS, instance = { DyeColor(id = it) }) {
        language(language)
    }

    /**
     * @return all the dye colors
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    suspend fun colors(language: Language? = null): List<DyeColor> = allIds(COLORS) {
        language(language)
    }
}