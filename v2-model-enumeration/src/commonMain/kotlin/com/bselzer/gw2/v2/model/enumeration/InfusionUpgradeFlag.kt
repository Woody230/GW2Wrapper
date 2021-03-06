package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class InfusionUpgradeFlag {
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