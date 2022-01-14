package com.bselzer.gw2.v2.model.profession.track

import com.bselzer.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Skill")
data class SkillTrack(
    /**
     * The id of the skill.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("skill_id")
    override val id: Int = 0,
) : TrainingTrack(), Identifiable<Int>