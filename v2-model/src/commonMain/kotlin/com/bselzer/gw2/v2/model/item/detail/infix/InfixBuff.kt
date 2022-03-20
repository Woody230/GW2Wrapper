package com.bselzer.gw2.v2.model.item.detail.infix

import com.bselzer.gw2.v2.model.skill.SkillId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfixBuff(
    /**
     * The id of the skill.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("skill_id")
    val skillId: SkillId = SkillId(),

    @SerialName("description")
    val description: String = ""
)
