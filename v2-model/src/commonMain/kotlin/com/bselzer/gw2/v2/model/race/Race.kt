package com.bselzer.gw2.v2.model.race

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.skill.SkillId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Race(
    @SerialName("id")
    override val id: RaceId = RaceId(),

    @SerialName("name")
    val name: String = "",

    /**
     * The ids of the skills usable by characters of this race.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("skills")
    val skillIds: List<SkillId> = emptyList()
) : Identifiable<String>