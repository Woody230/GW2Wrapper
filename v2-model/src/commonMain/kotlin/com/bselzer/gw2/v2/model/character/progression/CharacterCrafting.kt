package com.bselzer.gw2.v2.model.character.progression

import com.bselzer.gw2.v2.model.wrapper.CraftingDiscipline
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterCrafting(
    /**
     * The name of the discipline.
     * @see <a href="https://wiki.guildwars2.com/wiki/Crafting">the wiki</a>
     */
    @SerialName("discipline")
    val discipline: CraftingDiscipline = CraftingDiscipline(),

    /**
     * The discipline level.
     */
    @SerialName("rating")
    val level: Int = 0,

    /**
     * Whether this discipline is currently active on the character.
     */
    @SerialName("active")
    val isActive: Boolean = false
)