package com.bselzer.gw2.v2.model.wvw.map

import com.bselzer.gw2.v2.model.enumeration.wrapper.WvwMapType
import com.bselzer.gw2.v2.model.wvw.world.WvwWorldCount
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwMapScore(
    @SerialName("type")
    val mapType: WvwMapType = WvwMapType(),

    @SerialName("scores")
    val scores: WvwWorldCount = WvwWorldCount()
)