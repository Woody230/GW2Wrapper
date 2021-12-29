package com.bselzer.gw2.v2.model.wvw.match

import com.bselzer.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwMap(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("type")
    val type: String = "",

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
) : Identifiable<Int>