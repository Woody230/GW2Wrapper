package com.bselzer.library.gw2.v2.model.extension.common.enumeration.wvw

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class MapType
{
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