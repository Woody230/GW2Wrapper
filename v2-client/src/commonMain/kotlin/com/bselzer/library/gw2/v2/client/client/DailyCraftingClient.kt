package com.bselzer.library.gw2.v2.client.client

import io.ktor.client.*

/**
 * The daily crafting client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/dailycrafting">the wiki</a>
 */
class DailyCraftingClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val DAILY_CRAFTING = "dailycrafting"
    }

    /**
     * @return the ids of the daily time gated recipes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/dailycrafting">the wiki</a>
     */
    // TODO enum and extension method
    suspend fun ids(): List<String> = getList(path = DAILY_CRAFTING)
}