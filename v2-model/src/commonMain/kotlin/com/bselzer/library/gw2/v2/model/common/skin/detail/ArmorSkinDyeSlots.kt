package com.bselzer.library.gw2.v2.model.common.skin.detail

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
    val overrides: Map<String, ArmorSkinDyeSlot> = emptyMap()
)