package com.bselzer.gw2.v2.model.character

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterModeSpecializations(
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