package com.bselzer.library.gw2.v2.model.common.wvw.match

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Skirmish(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("scores")
    val scores: WorldCount = WorldCount(),

    @SerialName("map_scores")
    val mapScores: List<MapScore> = emptyList()
) : Identifiable<Int>