package com.bselzer.library.gw2.model.common.mechanics.skill

import com.bselzer.library.gw2.model.common.mechanics.AttunementName
import com.bselzer.library.gw2.model.common.mechanics.profession.ProfessionName
import com.bselzer.library.gw2.model.common.mechanics.profession.weapon.WeaponName
import com.bselzer.library.gw2.model.common.mechanics.skill.fact.SkillFact
import com.bselzer.library.gw2.model.common.mechanics.skill.fact.SkillTraitedFact
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Skill(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("chat_link")
    val chatLink: String = "",

    @SerialName("type")
    val type: SkillType? = null,

    @SerialName("weapon_type")
    val associatedWeapon: WeaponName? = null,

    @SerialName("professions")
    val associatedProfessions: List<ProfessionName> = emptyList(),

    @SerialName("slot")
    val slot: SkillSlot? = null,

    @SerialName("facts")
    val facts: List<SkillFact> = emptyList(),

    @SerialName("traited_facts")
    val traitedFacts: List<SkillTraitedFact> = emptyList(),

    @SerialName("categories")
    val categories: List<SkillCategory> = emptyList(),

    @SerialName("attunement")
    val attunement: AttunementName? = null,

    @SerialName("dual_attunement")
    val dualAttunement: AttunementName? = null,

    @SerialName("cost")
    val energyCost: Int = 0, // Revenant, Warrior, Druid

    @SerialName("dual_wield")
    val dualWieldRequiredOffhand: WeaponName? = null,

    @SerialName("flip_skill")
    val flipSkillId: Int = 0,

    @SerialName("initiative")
    val initiativeCost: Int = 0,

    @SerialName("next_chain")
    val nextChainSkillId: Int = 0,

    @SerialName("prev_chain")
    val prevChainSkillId: Int = 0,

    @SerialName("specialization")
    val specializationId: Int = 0, // Only exists for elite specialization skills

    @SerialName("transform_skills")
    val transformSkillIds: List<Int> = emptyList(),

    @SerialName("bundle_skills")
    val bundleSkillIds: List<Int> = emptyList(),

    @SerialName("toolbelt_skill")
    val toolbeltSkillId: Int = 0,

    @SerialName("flags")
    val flags: List<SkillFlag> = emptyList()
)