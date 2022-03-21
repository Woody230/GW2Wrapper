package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.model.daily.DailyCraftingId
import io.ktor.client.*

/**
 * The daily crafting client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/dailycrafting">the wiki</a>
 */
class DailyCraftingClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val DAILY_CRAFTING = "dailycrafting"
    }

    /**
     * @return the ids of the daily time gated recipes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/dailycrafting">the wiki</a>
     */
    suspend fun ids(): List<DailyCraftingId> = getIds(path = DAILY_CRAFTING)
}