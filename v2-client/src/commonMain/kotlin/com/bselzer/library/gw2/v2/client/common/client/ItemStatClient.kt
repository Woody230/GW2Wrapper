package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.itemstat.ItemStat
import io.ktor.client.*

/**
 * The item stat client.
 * <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">the wiki</a>
 */
class ItemStatClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val ITEM_STATS = "itemstats"
    }

    /**
     * @return the ids of the available item stats
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">the wiki</a>
     */
    suspend fun ids(): List<Int> = get(path = ITEM_STATS)

    /**
     * @return the item stat associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">the wiki</a>
     */
    suspend fun itemStat(id: Int, language: String? = null): ItemStat = single(id, ITEM_STATS) {
        language(language)
    }

    /**
     * @return the item stats associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">the wiki</a>
     */
    suspend fun itemStats(ids: Collection<Int>, language: String? = null): List<ItemStat> = chunkedIds(ids, ITEM_STATS) {
        language(language)
    }

    /**
     * @return all the item stats
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">the wiki</a>
     */
    suspend fun itemStats(language: String? = null): List<ItemStat> = allIds(ITEM_STATS) {
        language(language)
    }
}