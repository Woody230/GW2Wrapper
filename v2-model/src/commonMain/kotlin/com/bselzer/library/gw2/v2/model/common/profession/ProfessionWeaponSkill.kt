package com.bselzer.library.gw2.v2.model.common.profession

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfessionWeaponSkill(
    /**
     * The id of the skill.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("id")
    override val id: Int = 0,

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