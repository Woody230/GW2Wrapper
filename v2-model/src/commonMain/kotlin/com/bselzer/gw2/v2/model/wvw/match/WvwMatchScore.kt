package com.bselzer.gw2.v2.model.wvw.match

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.wvw.map.WvwMap
import com.bselzer.gw2.v2.model.wvw.match.skirmish.WvwSkirmish
import com.bselzer.gw2.v2.model.wvw.world.WvwWorldCount
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwMatchScore(
    @SerialName("id")
    override val id: WvwMatchId = WvwMatchId(),

    @SerialName("scores")
    val scores: WvwWorldCount = WvwWorldCount(),

    @SerialName("skirmishes")
    val skirmishes: List<WvwSkirmish> = emptyList(),

    @SerialName("victory_points")
    val victoryPoints: WvwWorldCount = WvwWorldCount(),

    @SerialName("maps")
    val maps: List<WvwMap> = emptyList()
) : Identifiable<String>