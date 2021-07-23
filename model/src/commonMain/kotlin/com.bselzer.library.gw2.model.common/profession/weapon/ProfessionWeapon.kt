package com.bselzer.library.gw2.model.common.profession.weapon

import com.bselzer.library.gw2.model.common.profession.ProfessionSkill
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfessionWeapon(
    @SerialName("flags")
    val flags: List<WeaponFlag> = emptyList(),

    @SerialName("specialization")
    val specializationId: Int = 0,

    @SerialName("skills")
    val professionSkills: List<ProfessionSkill> = emptyList()
)
