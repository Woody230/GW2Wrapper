package com.bselzer.gw2.v2.model.skin.detail

import com.bselzer.gw2.v2.model.enumeration.wrapper.RaceGender
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
    val overrides: Map<RaceGender, ArmorSkinDyeSlot> = emptyMap()
)