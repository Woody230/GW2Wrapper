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
    val slot: com.bselzer.gw2.v2.model.wrapper.SkillSlot = com.bselzer.gw2.v2.model.wrapper.SkillSlot(),

    /**
     * The weapon type of the required offhand. Used by Thieves for the dual wield skills.
     */
    @SerialName("offhand")
    val offhand: com.bselzer.gw2.v2.model.wrapper.WeaponType = com.bselzer.gw2.v2.model.wrapper.WeaponType()
) : Identifiable<Int>