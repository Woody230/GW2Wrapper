package com.bselzer.gw2.v2.model.character

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterSkills(
    /**
     * The id of the heal skill.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("heal")
    val healId: Int = 0,

    /**
     * The ids of the utility skills.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("utilities")
    val utilityIds: List<Int> = emptyList(),

    /**
     * The id of the elite skill.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("elite")
    val eliteId: Int = 0,

    /**
     * The ids of the legends for Revenants.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("legends")
    val legendIds: List<String?> = emptyList()
)