package com.bselzer.library.gw2.v2.model.common.profession.track

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Skill")
data class SkillTrack(
    override val cost: Int = 0,

    /**
     * The id of the skill.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("skill_id")
    val id: Int = 0,
) : TrainingTrack()