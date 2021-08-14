package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Items
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.legend.Legend
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The item client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
 */
class ItemClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available items
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    suspend fun ids(): List<Int> = httpClient.get(path = Items.ITEMS)

    /**
     * @return the items associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    suspend fun items(ids: Collection<Int>, language: String? = null): List<Legend> = chunkedIds(ids, Items.ITEMS) {
        language(language)
    }
}