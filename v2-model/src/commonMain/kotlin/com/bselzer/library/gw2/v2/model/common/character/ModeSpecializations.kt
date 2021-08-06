package com.bselzer.library.gw2.v2.model.common.character

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ModeSpecializations(
    /**
     * The player vs. environment specializations.
     */
    @SerialName("pve")
    val pve: List<CharacterSpecialization> = emptyList(),

    /**
     * The player vs. player specializations.
     */
    @SerialName("pvp")
    val pvp: List<CharacterSpecialization> = emptyList(),

    /**
     * The world vs. world specializations.
     */
    @SerialName("wvw")
    val wvw: List<CharacterSpecialization> = emptyList()
)