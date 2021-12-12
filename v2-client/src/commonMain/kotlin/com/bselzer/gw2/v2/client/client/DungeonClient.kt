package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.model.dungeon.Dungeon
import io.ktor.client.*

/**
 * The dungeon client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/dungeons">the wiki</a>
 */
class DungeonClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val DUNGEONS = "dungeons"
    }

    /**
     * @return the ids of the available dungeons
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/dungeons">the wiki</a>
     */
    suspend fun ids(): List<String> = getList(path = DUNGEONS)

    /**
     * @return the dungeon associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/dungeons">the wiki</a>
     */
    suspend fun dungeon(id: String, language: String? = null): Dungeon = getSingleById(id, DUNGEONS) {
        language(language)
    }

    /**
     * @return the dungeons associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/dungeons">the wiki</a>
     */
    suspend fun dungeons(ids: Collection<String>, language: String? = null): List<Dungeon> = chunkedIds(ids, DUNGEONS) {
        language(language)
    }

    /**
     * @return all the dungeons
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/dungeons">the wiki</a>
     */
    suspend fun dungeons(language: String? = null): List<Dungeon> = allIds(DUNGEONS) {
        language(language)
    }
}