package com.bselzer.library.gw2.v2.model.common.wvw.match

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MatchOverview(
    @SerialName("id")
    override val id: String = "",

    @SerialName("start_time")
    val startTime: Instant = Instant.DISTANT_PAST,

    @SerialName("end_time")
    val endTime: Instant = Instant.DISTANT_PAST,

    @SerialName("scores")
    val scores: WorldCount = WorldCount(),

    @SerialName("worlds")
    val worlds: WorldCount = WorldCount(),

    @SerialName("all_worlds")
    val allWorlds: WorldCounts = WorldCounts(),
) : Identifiable<String>