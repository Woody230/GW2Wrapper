package com.bselzer.gw2.v2.model.backstory.answer

import com.bselzer.gw2.v2.model.backstory.question.BackstoryQuestionId
import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.profession.ProfessionId
import com.bselzer.gw2.v2.model.race.RaceId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BackstoryAnswer(
    @SerialName("id")
    override val id: BackstoryAnswerId = BackstoryAnswerId(),

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
    val questionId: BackstoryQuestionId = BackstoryQuestionId(),

    /**
     * The names of the professions that can choose this answer.
     *
     * Empty if there are no profession requirements.
     */
    @SerialName("professions")
    val professions: List<ProfessionId> = emptyList(),

    /**
     * The names of the races that can choose this answer.
     *
     * Empty if there are no race requirements.
     */
    @SerialName("races")
    val races: List<RaceId> = emptyList()
) : Identifiable<String>