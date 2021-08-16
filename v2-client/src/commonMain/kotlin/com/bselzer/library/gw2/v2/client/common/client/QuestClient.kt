package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Quests
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.quest.Quest
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The quest client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quests">the wiki</a>
 */
class QuestClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available quests
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quests">the wiki</a>
     */
    suspend fun ids(): List<Int> = httpClient.get(path = Quests.QUESTS)

    /**
     * @return the quest associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quests">the wiki</a>
     */
    suspend fun quest(id: Int, language: String? = null): Quest = single(id, Quests.QUESTS) {
        language(language)
    }

    /**
     * @return the quests associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quests">the wiki</a>
     */
    suspend fun quests(ids: Collection<Int>, language: String? = null): List<Quest> = chunkedIds(ids, Quests.QUESTS) {
        language(language)
    }

    /**
     * @return all the quests
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quests">the wiki</a>
     */
    suspend fun quests(language: String? = null): List<Quest> = allIds(Quests.QUESTS) {
        language(language)
    }
}