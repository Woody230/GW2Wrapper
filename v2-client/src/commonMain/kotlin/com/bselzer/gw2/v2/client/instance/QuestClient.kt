package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.model.Language
import com.bselzer.gw2.v2.model.quest.Quest
import com.bselzer.gw2.v2.model.quest.QuestId
import io.ktor.client.*

/**
 * The quest client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quests">the wiki</a>
 */
class QuestClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val QUESTS = "quests"
    }

    /**
     * @return the ids of the available quests
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quests">the wiki</a>
     */
    suspend fun ids(): List<QuestId> = getIds(path = QUESTS)

    /**
     * @return the quest associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quests">the wiki</a>
     */
    suspend fun quest(id: QuestId, language: Language? = null): Quest = getSingleById(id, QUESTS, instance = { Quest(id = it) }) {
        language(language)
    }

    /**
     * @return the quests associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quests">the wiki</a>
     */
    suspend fun quests(ids: Collection<QuestId>, language: Language? = null): List<Quest> = chunkedIds(ids, QUESTS, instance = { Quest(id = it) }) {
        language(language)
    }

    /**
     * @return all the quests
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quests">the wiki</a>
     */
    suspend fun quests(language: Language? = null): List<Quest> = allIds(QUESTS) {
        language(language)
    }
}