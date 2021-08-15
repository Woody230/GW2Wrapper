package com.bselzer.library.gw2.v2.model.common.backstory

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BackstoryQuestion(
    @SerialName("id")
    val id: Int = 0,

    @SerialName("title")
    val title: String = "",

    @SerialName("description")
    val description: String = "",

    /**
     * The ids of the answer choices.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/answers">the wiki</a>
     */
    @SerialName("answers")
    val answerIds: List<String> = emptyList(),

    /**
     * The order this question gets when being displayed while answering biography questions during character creation.
     */
    @SerialName("order")
    val order: Int = 0,

    /**
     * The names of the professions that can choose this question.
     *
     * Null if there are no profession requirements.
     */
    @SerialName("professions")
    val professions: List<String>? = null,

    /**
     * The names of the races that can choose this question.
     *
     * Null if there are no race requirements.
     */
    @SerialName("races")
    val races: List<String>? = null
)