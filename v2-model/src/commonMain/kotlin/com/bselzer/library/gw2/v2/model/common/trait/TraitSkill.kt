package com.bselzer.library.gw2.v2.model.common.trait

import com.bselzer.library.gw2.v2.model.common.trait.fact.TraitFact
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TraitSkill(
    @SerialName("id")
    val id: Int = 0,

    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("facts")
    val facts: List<TraitFact> = emptyList(),

    @SerialName("traited_facts")
    val traitedFacts: List<TraitFact> = emptyList(),
)