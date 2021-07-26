package com.bselzer.library.gw2.model.common.wvw.match

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Map(
    @SerialName("id")
    val id: Int,

    @SerialName("type")
    val type: String = "",

    @SerialName("scores")
    val scores: WorldCount = WorldCount(),

    @SerialName("deaths")
    val deaths: WorldCount = WorldCount(),

    @SerialName("kills")
    val kills: WorldCount = WorldCount(),

    @SerialName("objectives")
    val objectives: List<MapObjective> = emptyList(),

    @SerialName("bonuses")
    val bonuses: List<MapBonus> = emptyList(),

    @SerialName("skirmishes")
    val skirmishes: List<Skirmish> = emptyList(),

    @SerialName("victory_points")
    val victoryPoints: WorldCount = WorldCount()
)