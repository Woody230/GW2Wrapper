package com.bselzer.gw2.v2.model.wvw.match

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.wvw.world.WvwWorldCount
import com.bselzer.gw2.v2.model.wvw.world.WvwWorldId
import com.bselzer.gw2.v2.model.wvw.world.WvwWorldIds
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwMatchOverview(
    @SerialName("id")
    override val id: WvwMatchId = WvwMatchId(),

    @SerialName("start_time")
    val startTime: Instant = Instant.DISTANT_PAST,

    @SerialName("end_time")
    val endTime: Instant = Instant.DISTANT_PAST,

    @SerialName("scores")
    val scores: WvwWorldCount = WvwWorldCount(),

    @SerialName("worlds")
    val worlds: WvwWorldId = WvwWorldId(),

    @SerialName("all_worlds")
    val allWorlds: WvwWorldIds = WvwWorldIds(),
) : Identifiable<String>