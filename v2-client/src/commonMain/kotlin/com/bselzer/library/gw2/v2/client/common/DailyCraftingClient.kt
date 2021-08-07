package com.bselzer.library.gw2.v2.client.common

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.DailyCrafting
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The daily crafting client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/dailycrafting">the wiki</a>
 */
class DailyCraftingClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the daily time gated recipes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/dailycrafting">the wiki</a>
     */
    // TODO enum and extension method
    suspend fun ids(): List<String> = httpClient.get(path = DailyCrafting.DAILY_CRAFTING)
}