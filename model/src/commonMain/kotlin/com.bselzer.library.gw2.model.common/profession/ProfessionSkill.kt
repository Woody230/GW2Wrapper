package com.bselzer.library.gw2.model.common.profession

import com.bselzer.library.gw2.model.common.AttunementName
import com.bselzer.library.gw2.model.common.profession.weapon.WeaponName
import com.bselzer.library.gw2.model.common.skill.SkillSlot
import com.bselzer.library.gw2.model.common.skill.SkillType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfessionSkill(
    @SerialName("id")
    val id: Int = 0,

    @SerialName("slot")
    val slot: SkillSlot? = null,

    @SerialName("type")
    val type: SkillType? = null,

    @SerialName("offhand")
    val offhandRequired: WeaponName? = null, // For Thief

    @SerialName("attunement")
    val attunementRequired: AttunementName? = null, // For Elementalist

    @SerialName("source")
    val stealSource: ProfessionName? = null // For Thief
)