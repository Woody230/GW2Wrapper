package com.bselzer.library.gw2.v2.model.common.wvw.match

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MapScore(
    @SerialName("type")
    val mapType: String = "",

    @SerialName("scores")
    val scores: WorldCount = WorldCount()
)