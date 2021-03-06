package com.bselzer.gw2.v2.model.trait

import com.bselzer.gw2.v2.model.enumeration.wrapper.TraitSlot
import com.bselzer.gw2.v2.model.enumeration.wrapper.TraitTier
import com.bselzer.gw2.v2.model.specialization.SpecializationId
import com.bselzer.gw2.v2.model.trait.fact.TraitFact
import com.bselzer.gw2.v2.model.wrapper.ImageLink
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Trait(
    @SerialName("id")
    override val id: TraitId = TraitId(),

    @SerialName("name")
    val name: String = "",

    @SerialName("icon")
    val iconLink: ImageLink = ImageLink(),

    @SerialName("description")
    val description: String = "",

    /**
     * The id of the specialization this trait belongs to.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki</a>
     */
    @SerialName("specialization")
    val specializationId: SpecializationId = SpecializationId(),

    @SerialName("tier")
    val tier: TraitTier = TraitTier(),

    @SerialName("slot")
    val slot: TraitSlot = TraitSlot(),

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
) : Identifiable<TraitId, Int>
