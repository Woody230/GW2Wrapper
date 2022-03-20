package com.bselzer.gw2.v2.model.character.skill

import com.bselzer.gw2.v2.model.legend.LegendId
import com.bselzer.gw2.v2.model.skill.SkillId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterSkills(
    /**
     * The id of the heal skill.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("heal")
    val healId: SkillId = SkillId(),

    /**
     * The ids of the utility skills.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("utilities")
    val utilityIds: List<SkillId> = emptyList(),

    /**
     * The id of the elite skill.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("elite")
    val eliteId: SkillId = SkillId(),

    /**
     * The ids of the legends for Revenants.
     *
     * An id will be null if there is no selection.
     *
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legends">the wiki</a>
     */
    @SerialName("legends")
    val legendIds: List<LegendId?> = emptyList()
)