package com.bselzer.gw2.v2.model.wvw.match

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwMapScore(
    @SerialName("type")
    val mapType: String = "",

    @SerialName("scores")
    val scores: WvwWorldCount = WvwWorldCount()
)