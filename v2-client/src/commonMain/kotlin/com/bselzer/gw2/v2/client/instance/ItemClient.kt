package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.request.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.model.item.DefaultItem
import com.bselzer.gw2.v2.model.item.Item
import com.bselzer.gw2.v2.model.item.ItemId
import io.ktor.client.*

/**
 * The item client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
 */
class ItemClient(httpClient: HttpClient, configuration: DefaultGw2HttpOptions) : BaseClient(httpClient, configuration) {
    private companion object {
        const val ITEMS = "items"
    }

    /**
     * @return the ids of the available items
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    suspend fun ids(): List<ItemId> = getIds(path = ITEMS)

    /**
     * @return the item associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    suspend fun item(id: ItemId, language: Language? = null): Item = getSingleById(id, ITEMS, instance = { DefaultItem(identifier = it) }) {
        language(language)
    }

    /**
     * @return the items associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    suspend fun items(ids: Collection<ItemId>, language: Language? = null): List<Item> = chunkedIds(ids, ITEMS, instance = { DefaultItem(identifier = it) }) {
        language(language)
    }
}