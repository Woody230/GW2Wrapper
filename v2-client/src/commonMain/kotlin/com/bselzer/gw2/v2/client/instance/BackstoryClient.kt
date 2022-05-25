package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.model.Language
import com.bselzer.gw2.v2.model.backstory.answer.BackstoryAnswer
import com.bselzer.gw2.v2.model.backstory.answer.BackstoryAnswerId
import com.bselzer.gw2.v2.model.backstory.question.BackstoryQuestion
import com.bselzer.gw2.v2.model.backstory.question.BackstoryQuestionId
import io.ktor.client.*

/**
 * The backstory client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory">the wiki</a>
 */
class BackstoryClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    internal companion object {
        const val BACKSTORY = "backstory"
        const val ANSWERS = "answers"
        const val QUESTIONS = "questions"
    }

    /**
     * @return the ids of the available answers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/answers">the wiki</a>
     */
    suspend fun answerIds(): List<BackstoryAnswerId> = getIds(path = "${BACKSTORY}/${ANSWERS}")

    /**
     * @return the answer associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/answers">the wiki</a>
     */
    suspend fun answer(id: BackstoryAnswerId, language: Language? = null): BackstoryAnswer =
        getSingleById(id, "${BACKSTORY}/${ANSWERS}", instance = { BackstoryAnswer(id = it) }) {
            language(language)
        }

    /**
     * @return the answers associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/answers">the wiki</a>
     */
    suspend fun answers(ids: Collection<BackstoryAnswerId>, language: Language? = null): List<BackstoryAnswer> =
        chunkedIds(ids, "${BACKSTORY}/${ANSWERS}", instance = { BackstoryAnswer(id = it) }) {
            language(language)
        }

    /**
     * @return all the answers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/answers">the wiki</a>
     */
    suspend fun answers(language: Language? = null): List<BackstoryAnswer> = allIds("${BACKSTORY}/${ANSWERS}") {
        language(language)
    }

    /**
     * @return the ids of the available questions
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/questions">the wiki</a>
     */
    suspend fun questionIds(): List<BackstoryQuestionId> = getIds(path = "${BACKSTORY}/${QUESTIONS}")

    /**
     * @return the question associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/questions">the wiki</a>
     */
    suspend fun question(id: BackstoryQuestionId, language: Language? = null): BackstoryQuestion =
        getSingleById(id, "${BACKSTORY}/${QUESTIONS}", instance = { BackstoryQuestion(id = it) }) {
            language(language)
        }

    /**
     * @return the questions associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/questions">the wiki</a>
     */
    suspend fun questions(ids: Collection<BackstoryQuestionId>, language: Language? = null): List<BackstoryQuestion> =
        chunkedIds(ids, "${BACKSTORY}/${QUESTIONS}", instance = { BackstoryQuestion(id = it) }) {
            language(language)
        }

    /**
     * @return all the questions
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/questions">the wiki</a>
     */
    suspend fun questions(language: Language? = null): List<BackstoryQuestion> = allIds("${BACKSTORY}/${QUESTIONS}") {
        language(language)
    }
}