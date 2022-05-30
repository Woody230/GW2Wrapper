package com.bselzer.gw2.v2.model.wvw.map

import com.bselzer.gw2.v2.model.enumeration.wrapper.WvwMapType
import com.bselzer.gw2.v2.model.map.MapId
import com.bselzer.gw2.v2.model.wvw.match.skirmish.WvwSkirmish
import com.bselzer.gw2.v2.model.wvw.world.WvwWorldCount
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwMap(
    @SerialName("id")
    override val id: MapId = MapId(),

    @SerialName("type")
    val type: WvwMapType = WvwMapType(),

    @SerialName("scores")
    val scores: WvwWorldCount = WvwWorldCount(),

    @SerialName("deaths")
    val deaths: WvwWorldCount = WvwWorldCount(),

    @SerialName("kills")
    val kills: WvwWorldCount = WvwWorldCount(),

    @SerialName("objectives")
    val objectives: List<WvwMapObjective> = emptyList(),

    @SerialName("bonuses")
    val bonuses: List<WvwMapBonus> = emptyList(),

    @SerialName("skirmishes")
    val skirmishes: List<WvwSkirmish> = emptyList(),
) : Identifiable<MapId, Int>