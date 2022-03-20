package com.bselzer.gw2.v2.model.pvp.hero.stat

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpHeroStats(
    @SerialName("offense")
    val offense: Int = 0,

    @SerialName("defense")
    val defense: Int = 0,

    @SerialName("speed")
    val speed: Int = 0
)