package com.bselzer.library.gw2.v2.client.common

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Legends
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.legend.Legend
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The legend client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legends">the wiki</a>
 */
class LegendClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available legends
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legends">the wiki</a>
     */
    suspend fun ids(): List<String> = httpClient.get(path = Legends.LEGENDS)

    /**
     * @return the legends associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legends">the wiki</a>
     */
    suspend fun legends(ids: Collection<String>, language: String? = null): List<Legend> = chunkedIds(ids, Legends.LEGENDS) {
        language(language)
    }

    /**
     * @return all the legends
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legends">the wiki</a>
     */
    suspend fun legends(language: String? = null): List<Legend> = allIds(Legends.LEGENDS) {
        language(language)
    }
}