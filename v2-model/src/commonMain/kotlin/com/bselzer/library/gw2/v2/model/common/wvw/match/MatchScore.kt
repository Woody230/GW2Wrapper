package com.bselzer.library.gw2.v2.model.common.wvw.match

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MatchScore(
    @SerialName("id")
    override val id: String = "",

    @SerialName("scores")
    val scores: WorldCount = WorldCount(),

    @SerialName("skirmishes")
    val skirmishes: List<Skirmish> = emptyList(),

    @SerialName("victory_points")
    val victoryPoints: WorldCount = WorldCount(),

    @SerialName("maps")
    val maps: List<Map> = emptyList()
) : Identifiable<String>