package com.bselzer.library.gw2.v2.model.extension.common.enumeration.pvp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class PvpLadderType
{
    @SerialName("ranked")
    RANKED,

    @SerialName("unranked")
    UNRANKED
}