package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.model.story.Story
import com.bselzer.gw2.v2.model.story.season.StorySeason
import io.ktor.client.*

/**
 * The story client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories">the wiki</a>
 */
class StoryClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val STORIES = "stories"
        const val SEASONS = "seasons"
    }

    /**
     * @return the ids of the available stories
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories">the wiki</a>
     */
    suspend fun ids(): List<Int> = getList(path = STORIES)

    /**
     * @return the story associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories">the wiki</a>
     */
    suspend fun story(id: Int, language: String? = null): Story = getSingleById(id, STORIES, instance = { Story(id = it) }) {
        language(language)
    }

    /**
     * @return the stories associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories">the wiki</a>
     */
    suspend fun stories(ids: Collection<Int>, language: String? = null): List<Story> = chunkedIds(ids, STORIES, instance = { Story(id = it) }) {
        language(language)
    }

    /**
     * @return all the stories
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories">the wiki</a>
     */
    suspend fun stories(language: String? = null): List<Story> = allIds(STORIES) {
        language(language)
    }

    /**
     * @return the ids of the available seasons
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories/seasons">the wiki</a>
     */
    suspend fun seasonIds(): List<String> = getList(path = "${STORIES}/${SEASONS}")

    /**
     * @return the season associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories/seasons">the wiki</a>
     */
    suspend fun season(id: String, language: String? = null): StorySeason = getSingleById(id, "${STORIES}/${SEASONS}", instance = { StorySeason(id = it) }) {
        language(language)
    }

    /**
     * @return the seasons associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories/seasons">the wiki</a>
     */
    suspend fun seasons(ids: Collection<String>, language: String? = null): List<StorySeason> = chunkedIds(ids, "${STORIES}/${SEASONS}", instance = { StorySeason(id = it) }) {
        language(language)
    }

    /**
     * @return all the seasons
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories/seasons">the wiki</a>
     */
    suspend fun seasons(language: String? = null): List<StorySeason> = allIds("${STORIES}/${SEASONS}") {
        language(language)
    }
}