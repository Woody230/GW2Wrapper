package com.bselzer.gw2.v2.model.profession

import com.bselzer.gw2.v2.model.specialization.SpecializationId
import com.bselzer.gw2.v2.model.value.WeaponFlag
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfessionWeapon(
    @SerialName("flags")
    val flags: List<WeaponFlag> = emptyList(),

    /**
     * The id of the specialization required to use this weapon.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki</a>
     */
    @SerialName("specialization")
    val specializationId: SpecializationId = SpecializationId(),

    @SerialName("skills")
    val skills: List<ProfessionWeaponSkill> = emptyList()
)
