package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.model.legend.Legend
import io.ktor.client.*

/**
 * The legend client. For Revenants.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legends">the wiki</a>
 */
class LegendClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val LEGENDS = "legends"
    }

    /**
     * @return the ids of the available legends
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legends">the wiki</a>
     */
    suspend fun ids(): List<String> = getList(path = LEGENDS)

    /**
     * @return the legend associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legends">the wiki</a>
     */
    suspend fun legend(id: String, language: String? = null): Legend = getSingleById(id, LEGENDS, instance = { Legend(id = it) }) {
        language(language)
    }

    /**
     * @return the legends associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legends">the wiki</a>
     */
    suspend fun legends(ids: Collection<String>, language: String? = null): List<Legend> = chunkedIds(ids, LEGENDS, instance = { Legend(id = it) }) {
        language(language)
    }

    /**
     * @return all the legends
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legends">the wiki</a>
     */
    suspend fun legends(language: String? = null): List<Legend> = allIds(LEGENDS) {
        language(language)
    }
}