package com.bselzer.library.gw2.v2.model.common.mechanics.skill

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
    val type: String = "",

    @SerialName("weapon_type")
    val associatedWeapon: String = "",

    @SerialName("professions")
    val associatedProfessions: List<String> = emptyList(),

    @SerialName("slot")
    val slot: String = "",

    @SerialName("facts")
    val facts: List<SkillFact> = emptyList(),

    @SerialName("traited_facts")
    val traitedFacts: List<SkillTraitedFact> = emptyList(),

    @SerialName("categories")
    val categories: List<String> = emptyList(),

    @SerialName("attunement")
    val attunement: String = "",

    @SerialName("dual_attunement")
    val dualAttunement: String = "",

    @SerialName("cost")
    val energyCost: Int = 0, // Revenant, Warrior, Druid

    @SerialName("dual_wield")
    val dualWieldRequiredOffhand: String = "",

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
    val flags: List<String> = emptyList()
)