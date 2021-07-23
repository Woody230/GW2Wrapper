package com.bselzer.library.gw2.model.common.mechanics.item.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class InfusionUpgradeFlag
{
    @SerialName("Enrichment")
    ENRICHMENT,

    @SerialName("Infusion")
    INFUSION,

    @SerialName("Defense")
    DEFENSE,

    @SerialName("Offense")
    OFFENSE,

    @SerialName("Utility")
    UTILITY,

    @SerialName("Agony")
    AGONY;
}
