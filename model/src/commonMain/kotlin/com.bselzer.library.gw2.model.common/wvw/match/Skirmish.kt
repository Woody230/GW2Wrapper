package com.bselzer.library.gw2.model.common.wvw.match

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Skirmish(
    @SerialName("id")
    val id: Int,

    @SerialName("scores")
    val scores: WorldCount = WorldCount(),

    @SerialName("map_scores")
    val mapScores: List<MapScore> = emptyList()
)