package com.bselzer.library.gw2.v2.client.common

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Dungeons
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.dungeon.Dungeon
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The dungeon client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/dungeons">the wiki</a>
 */
class DungeonClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available dungeons
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/dungeons">the wiki</a>
     */
    suspend fun ids(): List<String> = httpClient.get(path = Dungeons.DUNGEONS)

    /**
     * @return the dungeons associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/dungeons">the wiki</a>
     */
    suspend fun dungeons(ids: Collection<String>, language: String? = null): List<Dungeon> = chunkedIds(ids, Dungeons.DUNGEONS) {
        language(language)
    }

    /**
     * @return all the dungeons
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/dungeons">the wiki</a>
     */
    suspend fun dungeons(language: String? = null): List<Dungeon> = allIds(Dungeons.DUNGEONS) {
        language(language)
    }
}