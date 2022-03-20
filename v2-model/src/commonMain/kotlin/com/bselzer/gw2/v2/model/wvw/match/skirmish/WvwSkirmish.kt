package com.bselzer.gw2.v2.model.wvw.match.skirmish

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.wvw.map.WvwMapScore
import com.bselzer.gw2.v2.model.wvw.world.WvwWorldCount
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwSkirmish(
    @SerialName("id")
    override val id: WvwSkirmishId = WvwSkirmishId(),

    @SerialName("scores")
    val scores: WvwWorldCount = WvwWorldCount(),

    @SerialName("map_scores")
    val mapScores: List<WvwMapScore> = emptyList()
) : Identifiable<Int>