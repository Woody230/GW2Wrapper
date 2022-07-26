package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.model.story.Story
import com.bselzer.gw2.v2.model.story.StoryId
import com.bselzer.gw2.v2.model.story.season.StorySeason
import com.bselzer.gw2.v2.model.story.season.StorySeasonId
import io.ktor.client.*

/**
 * The story client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories">the wiki</a>
 */
class StoryClient(httpClient: HttpClient, configuration: DefaultGw2HttpOptions) : BaseClient(httpClient, configuration) {
    private companion object {
        const val STORIES = "stories"
        const val SEASONS = "seasons"
    }

    /**
     * @return the ids of the available stories
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories">the wiki</a>
     */
    suspend fun ids(): List<StoryId> = getIds(path = STORIES)

    /**
     * @return the story associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories">the wiki</a>
     */
    suspend fun story(id: StoryId, language: Language? = null): Story = getSingleById(id, STORIES, instance = { Story(id = it) }) {
        language(language)
    }

    /**
     * @return the stories associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories">the wiki</a>
     */
    suspend fun stories(ids: Collection<StoryId>, language: Language? = null): List<Story> = chunkedIds(ids, STORIES, instance = { Story(id = it) }) {
        language(language)
    }

    /**
     * @return all the stories
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories">the wiki</a>
     */
    suspend fun stories(language: Language? = null): List<Story> = allIds(STORIES) {
        language(language)
    }

    /**
     * @return the ids of the available seasons
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories/seasons">the wiki</a>
     */
    suspend fun seasonIds(): List<StorySeasonId> = getIds(path = "${STORIES}/${SEASONS}")

    /**
     * @return the season associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories/seasons">the wiki</a>
     */
    suspend fun season(id: StorySeasonId, language: Language? = null): StorySeason = getSingleById(id, "${STORIES}/${SEASONS}", instance = { StorySeason(id = it) }) {
        language(language)
    }

    /**
     * @return the seasons associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories/seasons">the wiki</a>
     */
    suspend fun seasons(ids: Collection<StorySeasonId>, language: Language? = null): List<StorySeason> =
        chunkedIds(ids, "${STORIES}/${SEASONS}", instance = { StorySeason(id = it) }) {
            language(language)
        }

    /**
     * @return all the seasons
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories/seasons">the wiki</a>
     */
    suspend fun seasons(language: Language? = null): List<StorySeason> = allIds("${STORIES}/${SEASONS}") {
        language(language)
    }
}