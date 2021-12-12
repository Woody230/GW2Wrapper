package com.bselzer.gw2.v2.model.trait

import com.bselzer.gw2.v2.model.extension.base.Identifiable
import com.bselzer.gw2.v2.model.trait.fact.TraitFact
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TraitSkill(
    @SerialName("id")
    override val id: Int = 0,

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
) : Identifiable<Int>