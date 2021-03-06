package com.bselzer.gw2.v2.model.template.build

import com.bselzer.gw2.v2.model.pet.PetId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BuildPets(
    /**
     * The ids of the selected pets on land. An id is null if it is not selected.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pets">the wiki</a>
     */
    @SerialName("terrestrial")
    val terrestrialIds: List<PetId?> = emptyList(),

    /**
     * The ids of the selected pets underwater. An id is null if it is not selected.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pets">the wiki</a>
     */
    @SerialName("aquatic")
    val aquaticIds: List<PetId?> = emptyList()
)