package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Backstories
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.backstory.BackstoryAnswer
import com.bselzer.library.gw2.v2.model.common.backstory.BackstoryQuestion
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The backstory client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory">the wiki</a>
 */
class BackstoryClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available answers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/answers">the wiki</a>
     */
    suspend fun answerIds(): List<String> = httpClient.get(path = "${Backstories.BACKSTORY}/${Backstories.ANSWERS}")

    /**
     * @return the answers associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/answers">the wiki</a>
     */
    suspend fun answers(ids: Collection<String>, language: String? = null): List<BackstoryAnswer> = chunkedIds(ids, "${Backstories.BACKSTORY}/${Backstories.ANSWERS}") {
        language(language)
    }

    /**
     * @return all the answers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/answers">the wiki</a>
     */
    suspend fun answers(language: String? = null): List<BackstoryAnswer> = allIds("${Backstories.BACKSTORY}/${Backstories.ANSWERS}") {
        language(language)
    }

    /**
     * @return the ids of the available questions
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/questions">the wiki</a>
     */
    suspend fun questionIds(): List<Int> = httpClient.get(path = "${Backstories.BACKSTORY}/${Backstories.QUESTIONS}")

    /**
     * @return the questions associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/questions">the wiki</a>
     */
    suspend fun questions(ids: Collection<Int>, language: String? = null): List<BackstoryQuestion> = chunkedIds(ids, "${Backstories.BACKSTORY}/${Backstories.QUESTIONS}") {
        language(language)
    }

    /**
     * @return all the questions
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/questions">the wiki</a>
     */
    suspend fun questions(language: String? = null): List<BackstoryQuestion> = allIds("${Backstories.BACKSTORY}/${Backstories.QUESTIONS}") {
        language(language)
    }
}