package com.bselzer.gw2.v2.model.trait

import com.bselzer.gw2.v2.model.skill.SkillId
import com.bselzer.gw2.v2.model.trait.fact.TraitFact
import com.bselzer.gw2.v2.model.wrapper.ImageLink
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TraitSkill(
    @SerialName("id")
    override val id: SkillId = SkillId(),

    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    @SerialName("icon")
    val iconLink: ImageLink = ImageLink(),

    @SerialName("facts")
    val facts: List<TraitFact> = emptyList(),

    @SerialName("traited_facts")
    val traitedFacts: List<TraitFact> = emptyList(),
) : Identifiable<Int>