package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.model.Language
import com.bselzer.gw2.v2.model.itemstat.ItemStat
import com.bselzer.gw2.v2.model.itemstat.ItemStatId
import io.ktor.client.*

/**
 * The item stat client.
 * <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">the wiki</a>
 */
class ItemStatClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val ITEM_STATS = "itemstats"
    }

    /**
     * @return the ids of the available item stats
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">the wiki</a>
     */
    suspend fun ids(): List<ItemStatId> = getIds(path = ITEM_STATS)

    /**
     * @return the item stat associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">the wiki</a>
     */
    suspend fun itemStat(id: ItemStatId, language: Language? = null): ItemStat = getSingleById(id, ITEM_STATS, instance = { ItemStat(id = it) }) {
        language(language)
    }

    /**
     * @return the item stats associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">the wiki</a>
     */
    suspend fun itemStats(ids: Collection<ItemStatId>, language: Language? = null): List<ItemStat> = chunkedIds(ids, ITEM_STATS, instance = { ItemStat(id = it) }) {
        language(language)
    }

    /**
     * @return all the item stats
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">the wiki</a>
     */
    suspend fun itemStats(language: Language? = null): List<ItemStat> = allIds(ITEM_STATS) {
        language(language)
    }
}