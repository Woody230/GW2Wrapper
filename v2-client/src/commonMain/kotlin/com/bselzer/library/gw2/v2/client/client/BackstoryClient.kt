package com.bselzer.library.gw2.v2.client.client

import com.bselzer.library.gw2.v2.client.extension.language
import com.bselzer.library.gw2.v2.model.backstory.BackstoryAnswer
import com.bselzer.library.gw2.v2.model.backstory.BackstoryQuestion
import io.ktor.client.*

/**
 * The backstory client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory">the wiki</a>
 */
class BackstoryClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    internal companion object
    {
        const val BACKSTORY = "backstory"
        const val ANSWERS = "answers"
        const val QUESTIONS = "questions"
    }

    /**
     * @return the ids of the available answers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/answers">the wiki</a>
     */
    suspend fun answerIds(): List<String> = get(path = "${BACKSTORY}/${ANSWERS}")

    /**
     * @return the answer associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/answers">the wiki</a>
     */
    suspend fun answer(id: String, language: String? = null): BackstoryAnswer = single(id, "${BACKSTORY}/${ANSWERS}") {
        language(language)
    }

    /**
     * @return the answers associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/answers">the wiki</a>
     */
    suspend fun answers(ids: Collection<String>, language: String? = null): List<BackstoryAnswer> = chunkedIds(ids, "${BACKSTORY}/${ANSWERS}") {
        language(language)
    }

    /**
     * @return all the answers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/answers">the wiki</a>
     */
    suspend fun answers(language: String? = null): List<BackstoryAnswer> = allIds("${BACKSTORY}/${ANSWERS}") {
        language(language)
    }

    /**
     * @return the ids of the available questions
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/questions">the wiki</a>
     */
    suspend fun questionIds(): List<Int> = get(path = "${BACKSTORY}/${QUESTIONS}")

    /**
     * @return the question associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/questions">the wiki</a>
     */
    suspend fun question(id: Int, language: String? = null): BackstoryQuestion = single(id, "${BACKSTORY}/${QUESTIONS}") {
        language(language)
    }

    /**
     * @return the questions associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/questions">the wiki</a>
     */
    suspend fun questions(ids: Collection<Int>, language: String? = null): List<BackstoryQuestion> = chunkedIds(ids, "${BACKSTORY}/${QUESTIONS}") {
        language(language)
    }

    /**
     * @return all the questions
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/questions">the wiki</a>
     */
    suspend fun questions(language: String? = null): List<BackstoryQuestion> = allIds("${BACKSTORY}/${QUESTIONS}") {
        language(language)
    }
}