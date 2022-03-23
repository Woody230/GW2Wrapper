package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class PvpLadderType {
    @SerialName("ranked")
    RANKED,

    @SerialName("unranked")
    UNRANKED
}