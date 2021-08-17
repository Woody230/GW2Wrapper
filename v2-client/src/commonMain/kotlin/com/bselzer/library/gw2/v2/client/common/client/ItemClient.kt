package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.item.Item
import io.ktor.client.*

/**
 * The item client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
 */
class ItemClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val ITEMS = "items"
    }

    /**
     * @return the ids of the available items
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    suspend fun ids(): List<Int> = get(path = ITEMS)

    /**
     * @return the item associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    suspend fun item(id: Int, language: String? = null): List<Item> = single(id, ITEMS) {
        language(language)
    }

    /**
     * @return the items associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    suspend fun items(ids: Collection<Int>, language: String? = null): List<Item> = chunkedIds(ids, ITEMS) {
        language(language)
    }
}