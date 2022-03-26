package com.bselzer.gw2.v2.model.backstory.question

import com.bselzer.gw2.v2.model.backstory.answer.BackstoryAnswerId
import com.bselzer.gw2.v2.model.profession.ProfessionId
import com.bselzer.gw2.v2.model.race.RaceId
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BackstoryQuestion(
    @SerialName("id")
    override val id: BackstoryQuestionId = BackstoryQuestionId(),

    @SerialName("title")
    val title: String = "",

    @SerialName("description")
    val description: String = "",

    /**
     * The ids of the answer choices.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/answers">the wiki</a>
     */
    @SerialName("answers")
    val answerIds: List<BackstoryAnswerId> = emptyList(),

    /**
     * The order this question gets when being displayed while answering biography questions during character creation.
     */
    @SerialName("order")
    val order: Int = 0,

    /**
     * The names of the professions that can choose this question.
     *
     * Empty if there are no profession requirements.
     */
    @SerialName("professions")
    val professions: List<ProfessionId> = emptyList(),

    /**
     * The names of the races that can choose this question.
     *
     * Empty if there are no race requirements.
     */
    @SerialName("races")
    val races: List<RaceId> = emptyList()
) : Identifiable<Int>