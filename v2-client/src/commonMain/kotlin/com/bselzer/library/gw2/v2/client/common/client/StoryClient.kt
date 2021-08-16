package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Stories
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.story.Story
import com.bselzer.library.gw2.v2.model.common.story.StorySeason
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The story client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories">the wiki</a>
 */
class StoryClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available stories
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories">the wiki</a>
     */
    suspend fun ids(): List<Int> = httpClient.get(path = Stories.STORIES)

    /**
     * @return the story associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories">the wiki</a>
     */
    suspend fun story(id: Int, language: String? = null): Story = single(id, Stories.STORIES) {
        language(language)
    }

    /**
     * @return the stories associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories">the wiki</a>
     */
    suspend fun stories(ids: Collection<Int>, language: String? = null): List<Story> = chunkedIds(ids, Stories.STORIES) {
        language(language)
    }

    /**
     * @return all the stories
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories">the wiki</a>
     */
    suspend fun stories(language: String? = null): List<Story> = allIds(Stories.STORIES) {
        language(language)
    }

    /**
     * @return the ids of the available seasons
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories/seasons">the wiki</a>
     */
    suspend fun seasonIds(): List<String> = httpClient.get(path = "${Stories.STORIES}/${Stories.SEASONS}")

    /**
     * @return the season associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories/seasons">the wiki</a>
     */
    suspend fun season(id: String, language: String? = null): StorySeason = single(id, "${Stories.STORIES}/${Stories.SEASONS}") {
        language(language)
    }

    /**
     * @return the seasons associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories/seasons">the wiki</a>
     */
    suspend fun seasons(ids: Collection<String>, language: String? = null): List<StorySeason> = chunkedIds(ids, "${Stories.STORIES}/${Stories.SEASONS}") {
        language(language)
    }

    /**
     * @return all the seasons
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories/seasons">the wiki</a>
     */
    suspend fun seasons(language: String? = null): List<StorySeason> = allIds("${Stories.STORIES}/${Stories.SEASONS}") {
        language(language)
    }
}