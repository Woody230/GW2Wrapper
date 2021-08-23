package com.bselzer.library.gw2.v2.model.wvw.match

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwSkirmish(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("scores")
    val scores: WvwWorldCount = WvwWorldCount(),

    @SerialName("map_scores")
    val mapScores: List<WvwMapScore> = emptyList()
) : Identifiable<Int>