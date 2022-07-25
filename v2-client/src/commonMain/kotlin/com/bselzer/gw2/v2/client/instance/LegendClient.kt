package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.request.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.model.legend.Legend
import com.bselzer.gw2.v2.model.legend.LegendId
import io.ktor.client.*

/**
 * The legend client. For Revenants.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legends">the wiki</a>
 */
class LegendClient(httpClient: HttpClient, configuration: DefaultGw2HttpOptions) : BaseClient(httpClient, configuration) {
    private companion object {
        const val LEGENDS = "legends"
    }

    /**
     * @return the ids of the available legends
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legends">the wiki</a>
     */
    suspend fun ids(): List<LegendId> = getIds(path = LEGENDS)

    /**
     * @return the legend associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legends">the wiki</a>
     */
    suspend fun legend(id: LegendId, language: Language? = null): Legend = getSingleById(id, LEGENDS, instance = { Legend(id = it) }) {
        language(language)
    }

    /**
     * @return the legends associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legends">the wiki</a>
     */
    suspend fun legends(ids: Collection<LegendId>, language: Language? = null): List<Legend> = chunkedIds(ids, LEGENDS, instance = { Legend(id = it) }) {
        language(language)
    }

    /**
     * @return all the legends
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legends">the wiki</a>
     */
    suspend fun legends(language: Language? = null): List<Legend> = allIds(LEGENDS) {
        language(language)
    }
}