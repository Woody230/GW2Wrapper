package com.bselzer.gw2.v2.model.skin.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArmorSkinDyeSlots(
    @SerialName("default")
    val defaults: List<ArmorSkinDyeSlot> = emptyList(),

    /**
     * A map of the race/gender names to the dye slot override.
     */
    @SerialName("overrides")
    val overrides: Map<com.bselzer.gw2.v2.model.wrapper.RaceGender, ArmorSkinDyeSlot> = emptyMap()
)