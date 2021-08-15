package com.bselzer.library.gw2.v2.model.common.backstory

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BackstoryAnswer(
    @SerialName("id")
    val id: String = "",

    @SerialName("title")
    val title: String = "",

    @SerialName("description")
    val description: String = "",

    /**
     * The entry in the story journal.
     */
    @SerialName("journal")
    val journal: String = "",

    /**
     * The id of the question this is an answer for.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/questions">the wiki</a>
     */
    @SerialName("question")
    val questionId: Int = 0,

    /**
     * The names of the professions that can choose this answer.
     */
    @SerialName("professions")
    val professions: List<String> = emptyList(),

    /**
     * The names of the races that can choose this answer.
     */
    @SerialName("races")
    val races: List<String> = emptyList()
)