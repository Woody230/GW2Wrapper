package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.color.DyeColor
import io.ktor.client.*

/**
 * The color client for dyes.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
 */
class ColorClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val COLORS = "colors"
    }

    /**
     * @return the ids of the available dye colors
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    suspend fun ids(): List<Int> = get(path = COLORS)

    /**
     * @return the dye color associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    suspend fun color(id: Int, language: String? = null): DyeColor = single(id, COLORS) {
        language(language)
    }

    /**
     * @return the dye colors associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    suspend fun colors(ids: Collection<Int>, language: String? = null): List<DyeColor> = chunkedIds(ids, COLORS) {
        language(language)
    }

    /**
     * @return all the dye colors
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    suspend fun colors(language: String? = null): List<DyeColor> = allIds(COLORS) {
        language(language)
    }
}