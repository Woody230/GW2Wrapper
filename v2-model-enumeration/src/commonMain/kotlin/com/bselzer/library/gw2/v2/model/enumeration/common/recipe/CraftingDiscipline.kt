package com.bselzer.library.gw2.v2.model.enumeration.common.recipe

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CraftingDiscipline
{
    @SerialName("Armorsmith")
    ARMORSMITH,

    @SerialName("Artificer")
    ARTIFICER,

    @SerialName("Chef")
    CHEF,

    @SerialName("Huntsman")
    HUNTSMAN,

    @SerialName("Jeweler")
    JEWELER,

    @SerialName("Leatherworker")
    LEATHERWORKER,

    @SerialName("Scribe")
    SCRIBE,

    @SerialName("Tailor")
    TAILOR,

    @SerialName("Weaponsmith")
    WEAPONSMITH
}