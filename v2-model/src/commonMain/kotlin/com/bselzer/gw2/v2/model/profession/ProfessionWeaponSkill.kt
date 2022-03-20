package com.bselzer.gw2.v2.model.profession

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.skill.SkillId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfessionWeaponSkill(
    /**
     * The id of the skill.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("id")
    override val id: SkillId = SkillId(),

    /**
     * The skill slot the skill belongs to.
     */
    @SerialName("slot")
    val slot: String = "",

    /**
     * The weapon type of the required offhand. Used by Thieves for the dual wield skills.
     */
    @SerialName("offhand")
    val offhand: String = ""
) : Identifiable<Int>