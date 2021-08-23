package com.bselzer.library.gw2.v2.client.client

import com.bselzer.library.gw2.v2.model.armory.ArmoryItem
import io.ktor.client.*

/**
 * The legendary armory client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legendaryarmory">the wiki</a>
 */
class LegendaryArmoryClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val LEGENDARY_ARMORY = "legendaryarmory"
    }

    /**
     * @return the ids of the available items in the legendary armory
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legendaryarmory">the wiki</a>
     */
    suspend fun ids(): List<Int> = get(path = LEGENDARY_ARMORY)

    /**
     * @return the legendary item associated with the [id] in the armory
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legendaryarmory">the wiki</a>
     */
    suspend fun legendary(id: Int): ArmoryItem = single(id, LEGENDARY_ARMORY)

    /**
     * @return the legendary items associated with the [ids] in the armory
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legendaryarmory">the wiki</a>
     */
    suspend fun legendaries(ids: Collection<Int>): List<ArmoryItem> = chunkedIds(ids, LEGENDARY_ARMORY)

    /**
     * @return all the legendary armory items
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legendaryarmory">the wiki</a>
     */
    suspend fun legendaries(): List<ArmoryItem> = allIds(LEGENDARY_ARMORY)
}