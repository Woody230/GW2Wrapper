package com.bselzer.gw2.v2.model.character.skill

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterModeSkills(
    /**
     * The player vs. environment skills.
     */
    @SerialName("pve")
    val pve: CharacterSkills = CharacterSkills(),

    /**
     * The player vs. player skills.
     */
    @SerialName("pvp")
    val pvp: CharacterSkills = CharacterSkills(),

    /**
     * The world vs. world skills.
     */
    @SerialName("wvw")
    val wvw: CharacterSkills = CharacterSkills()
)