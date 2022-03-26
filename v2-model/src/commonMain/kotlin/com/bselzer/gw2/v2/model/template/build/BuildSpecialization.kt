package com.bselzer.gw2.v2.model.template.build

import com.bselzer.gw2.v2.model.specialization.SpecializationId
import com.bselzer.gw2.v2.model.trait.TraitId
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BuildSpecialization(
    /**
     * The id of the specialization.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki</a>
     */
    @SerialName("id")
    override val id: SpecializationId = SpecializationId(),

    /**
     * The ids of the selected traits.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    @SerialName("traits")
    val traitIds: List<TraitId> = emptyList()
) : Identifiable<Byte>