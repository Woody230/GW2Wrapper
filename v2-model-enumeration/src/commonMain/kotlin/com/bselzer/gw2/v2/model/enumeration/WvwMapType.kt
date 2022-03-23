package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class WvwMapType {
    @SerialName("Center")
    ETERNAL_BATTLEGROUNDS,

    @SerialName("RedHome")
    RED_BORDERLANDS,

    @SerialName("BlueHome")
    BLUE_BORDERLANDS,

    @SerialName("GreenHome")
    GREEN_BORDERLANDS,

    @SerialName("EdgeOfTheMists")
    EDGE_OF_THE_MISTS
}