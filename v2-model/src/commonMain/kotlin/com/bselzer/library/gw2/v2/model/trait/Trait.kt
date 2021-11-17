package com.bselzer.library.gw2.v2.model.trait

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import com.bselzer.library.gw2.v2.model.trait.fact.TraitFact
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Trait(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("name")
    val name: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("description")
    val description: String = "",

    /**
     * The id of the specialization this trait belongs to.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki</a>
     */
    @SerialName("specialization")
    val specializationId: Int = 0,

    @SerialName("tier")
    val tier: Int = Int.MIN_VALUE,

    @SerialName("slot")
    val slot: String = "",

    /**
     * The position of this trait within the [tier].
     */
    @SerialName("order")
    val order: Int = 0,

    @SerialName("facts")
    val facts: List<TraitFact> = emptyList(),

    @SerialName("traited_facts")
    val traitedFacts: List<TraitFact> = emptyList(),

    @SerialName("skills")
    val skills: List<TraitSkill> = emptyList()
) : Identifiable<Int>
