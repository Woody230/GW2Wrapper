package com.bselzer.library.gw2.v2.model.common.mechanics.trait

import com.bselzer.library.gw2.v2.model.common.skill.fact.SkillFact
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Trait(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("description")
    val description: String = "",

    @SerialName("specialization")
    val specializationId: Int = 0,

    @SerialName("tier")
    val tier: Int = -1, // 0 = elite weapon access, 1-3 Adept/Master/Grandmaster

    @SerialName("slot")
    val slot: String = "",

    @SerialName("order")
    val order: Int = 0, // Only meaningful for Major traits

    @SerialName("facts")
    val facts: List<SkillFact> = emptyList(),

    @SerialName("traited_facts")
    val traitedFacts: List<SkillFact> = emptyList(),

    @SerialName("skills")
    val skills: List<TraitSkill> = emptyList()
)
