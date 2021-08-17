package com.bselzer.library.gw2.v2.model.common.character

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterTraining(
    /**
     * The id of the skill tree associated with the profession's training.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/professions">the wiki</a>
     */
    @SerialName("id")
    override val id: Int = 0,

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