package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.model.armory.ArmoryItem
import com.bselzer.gw2.v2.model.item.ItemId
import io.ktor.client.*

/**
 * The legendary armory client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legendaryarmory">the wiki</a>
 */
class LegendaryArmoryClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val LEGENDARY_ARMORY = "legendaryarmory"
    }

    /**
     * @return the ids of the available items in the legendary armory
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legendaryarmory">the wiki</a>
     */
    suspend fun ids(): List<ItemId> = getIds(path = LEGENDARY_ARMORY)

    /**
     * @return the legendary item associated with the [id] in the armory
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legendaryarmory">the wiki</a>
     */
    suspend fun legendary(id: ItemId): ArmoryItem = getSingleById(id, LEGENDARY_ARMORY, instance = { ArmoryItem(id = it) })

    /**
     * @return the legendary items associated with the [ids] in the armory
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legendaryarmory">the wiki</a>
     */
    suspend fun legendaries(ids: Collection<ItemId>): List<ArmoryItem> = chunkedIds(ids, LEGENDARY_ARMORY, instance = { ArmoryItem(id = it) })

    /**
     * @return all the legendary armory items
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legendaryarmory">the wiki</a>
     */
    suspend fun legendaries(): List<ArmoryItem> = allIds(LEGENDARY_ARMORY)
}