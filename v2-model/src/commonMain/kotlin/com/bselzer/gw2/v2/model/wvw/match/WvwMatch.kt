package com.bselzer.gw2.v2.model.wvw.match

import com.bselzer.gw2.v2.model.wvw.map.WvwMap
import com.bselzer.gw2.v2.model.wvw.world.WvwWorldCount
import com.bselzer.gw2.v2.model.wvw.world.WvwWorldId
import com.bselzer.gw2.v2.model.wvw.world.WvwWorldIds
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwMatch(
    @SerialName("id")
    override val id: WvwMatchId = WvwMatchId(),

    @SerialName("start_time")
    val startTime: Instant = Instant.DISTANT_PAST,

    @SerialName("end_time")
    val endTime: Instant = Instant.DISTANT_PAST,

    @SerialName("scores")
    val scores: WvwWorldCount = WvwWorldCount(),

    /**
     * The main worlds.
     */
    @SerialName("worlds")
    val worlds: WvwWorldId = WvwWorldId(),

    /**
     * All of the worlds, including links.
     */
    @SerialName("all_worlds")
    val allWorlds: WvwWorldIds = WvwWorldIds(),

    @SerialName("deaths")
    val deaths: WvwWorldCount = WvwWorldCount(),

    @SerialName("kills")
    val kills: WvwWorldCount = WvwWorldCount(),

    @SerialName("victory_points")
    val victoryPoints: WvwWorldCount = WvwWorldCount(),

    @SerialName("maps")
    val maps: List<WvwMap> = emptyList()
) : Identifiable<WvwMatchId, String>