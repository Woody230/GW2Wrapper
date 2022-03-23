package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// TODO note that usages are broken https://github.com/gw2-api/issues/issues/6
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