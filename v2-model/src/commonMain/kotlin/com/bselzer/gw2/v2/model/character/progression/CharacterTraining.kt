package com.bselzer.gw2.v2.model.character.progression

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.profession.TrainingId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterTraining(
    /**
     * The id of the skill tree associated with the profession's training.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/professions">the wiki</a>
     */
    @SerialName("id")
    override val id: TrainingId = TrainingId(),

    /**
     * The number of hero points spent.
     */
    @SerialName("spent")
    val spent: Int = 0,

    /**
     * Whether the skill tree is fully trained.
     */
    @SerialName("done")
    val isDone: Boolean = false
) : Identifiable<Int>