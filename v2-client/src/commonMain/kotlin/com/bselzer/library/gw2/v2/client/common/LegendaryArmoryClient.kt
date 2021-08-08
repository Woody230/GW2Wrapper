package com.bselzer.library.gw2.v2.client.common

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Armory
import com.bselzer.library.gw2.v2.model.common.armory.ArmoryItem
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The legendary armory client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legendaryarmory">the wiki</a>
 */
class LegendaryArmoryClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available items in the legendary armory
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legendaryarmory">the wiki</a>
     */
    suspend fun ids(): List<Int> = httpClient.get(path = Armory.LEGENDARY_ARMORY)

    /**
     * @return the legendary items associated with the [ids] in the armory
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legendaryarmory">the wiki</a>
     */
    suspend fun legendaries(ids: Collection<Int>): List<ArmoryItem> = chunkedIds(ids, Armory.LEGENDARY_ARMORY)

    /**
     * @return all the legendary armory items
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legendaryarmory">the wiki</a>
     */
    suspend fun legendaries(): List<ArmoryItem> = allIds(Armory.LEGENDARY_ARMORY)
}