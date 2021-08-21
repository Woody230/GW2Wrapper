package com.bselzer.library.gw2.v2.model.common.profession

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfessionWeapon(
    @SerialName("flags")
    val flags: List<String> = emptyList(),

    /**
     * The id of the specialization required to use this weapon.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki</a>
     */
    @SerialName("specialization")
    val specializationId: Int = 0,

    @SerialName("skills")
    val skills: List<ProfessionWeaponSkill> = emptyList()
)
