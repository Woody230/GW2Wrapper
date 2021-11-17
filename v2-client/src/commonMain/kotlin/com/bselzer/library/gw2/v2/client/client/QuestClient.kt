package com.bselzer.library.gw2.v2.client.client

import com.bselzer.library.gw2.v2.client.extension.language
import com.bselzer.library.gw2.v2.model.quest.Quest
import io.ktor.client.*

/**
 * The quest client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quests">the wiki</a>
 */
class QuestClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val QUESTS = "quests"
    }

    /**
     * @return the ids of the available quests
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quests">the wiki</a>
     */
    suspend fun ids(): List<Int> = getList(path = QUESTS)

    /**
     * @return the quest associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quests">the wiki</a>
     */
    suspend fun quest(id: Int, language: String? = null): Quest = getSingleById(id, QUESTS) {
        language(language)
    }

    /**
     * @return the quests associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quests">the wiki</a>
     */
    suspend fun quests(ids: Collection<Int>, language: String? = null): List<Quest> = chunkedIds(ids, QUESTS) {
        language(language)
    }

    /**
     * @return all the quests
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quests">the wiki</a>
     */
    suspend fun quests(language: String? = null): List<Quest> = allIds(QUESTS) {
        language(language)
    }
}