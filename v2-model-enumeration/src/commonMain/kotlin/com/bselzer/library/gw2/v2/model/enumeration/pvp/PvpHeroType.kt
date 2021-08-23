package com.bselzer.library.gw2.v2.model.enumeration.pvp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class PvpHeroType
{
    @SerialName("Offensive Hero")
    OFFENSIVE,

    @SerialName("Defensive Hero")
    DEFENSIVE,

    @SerialName("Specialist Hero")
    SPECIALIST
}