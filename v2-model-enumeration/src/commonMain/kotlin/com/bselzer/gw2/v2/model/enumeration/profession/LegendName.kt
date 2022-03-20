package com.bselzer.gw2.v2.model.enumeration.profession

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class LegendName {
    @SerialName("Legend1")
    DRAGON,

    @SerialName("Legend2")
    ASSASSIN,

    @SerialName("Legend3")
    DWARF,

    @SerialName("Legend4")
    DEMON,

    @SerialName("Legend5")
    RENEGADE,

    @SerialName("Legend6")
    CENTAUR,

    @SerialName("Legend7")
    ALLIANCE
}