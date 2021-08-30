package com.bselzer.library.gw2.v2.model.wvw.match

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwMatch(
    @SerialName("id")
    override val id: String = "",

    @SerialName("start_time")
    val startTime: Instant = Instant.DISTANT_PAST,

    @SerialName("end_time")
    val endTime: Instant = Instant.DISTANT_PAST,

    @SerialName("scores")
    val scores: WvwWorldCount = WvwWorldCount(),

    @SerialName("worlds")
    val worlds: WvwWorldCount = WvwWorldCount(),

    @SerialName("all_worlds")
    val allWorlds: WvwWorldCounts = WvwWorldCounts(),

    @SerialName("deaths")
    val deaths: WvwWorldCount = WvwWorldCount(),

    @SerialName("kills")
    val kills: WvwWorldCount = WvwWorldCount(),

    @SerialName("victory_points")
    val victoryPoints: WvwWorldCount = WvwWorldCount(),

    @SerialName("maps")
    val maps: List<WvwMap> = emptyList()
) : Identifiable<String>