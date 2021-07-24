package com.bselzer.library.gw2.model.common.wvw.match

import com.bselzer.library.gw2.model.common.wvw.match.map.Map
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Match(
    @SerialName("id")
    val id: String,

    @SerialName("start_time")
    val startTime: LocalDateTime,

    @SerialName("end_time")
    val endTime: LocalDateTime,

    @SerialName("scores")
    val scores: WorldCount = WorldCount(),

    @SerialName("worlds")
    val worlds: WorldCount = WorldCount(),

    @SerialName("all_worlds")
    val allWorlds: WorldCounts = WorldCounts(),

    @SerialName("deaths")
    val deaths: WorldCount = WorldCount(),

    @SerialName("kills")
    val kills: WorldCount = WorldCount(),

    @SerialName("victory_points")
    val victoryPoints: WorldCount = WorldCount(),

    @SerialName("maps")
    val maps: List<Map> = emptyList()
)