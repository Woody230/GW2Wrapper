package com.bselzer.library.gw2.v2.model.common.mechanics.profession

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfessionWeapon(
    @SerialName("flags")
    val flags: List<String> = emptyList(),

    @SerialName("specialization")
    val specializationId: Int = 0,

    @SerialName("skills")
    val professionSkills: List<ProfessionSkill> = emptyList()
)
