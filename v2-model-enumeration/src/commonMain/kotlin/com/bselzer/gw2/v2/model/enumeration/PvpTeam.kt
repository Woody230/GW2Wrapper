package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class PvpTeam {
    @SerialName("Red")
    RED,

    @SerialName("Blue")
    BLUE
}