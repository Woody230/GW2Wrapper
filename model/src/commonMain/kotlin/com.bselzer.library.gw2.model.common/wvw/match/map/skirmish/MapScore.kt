package com.bselzer.library.gw2.model.common.wvw.match.map.skirmish

import com.bselzer.library.gw2.model.common.wvw.match.WorldCount
import com.bselzer.library.gw2.model.common.wvw.match.map.MapType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MapScore(
    @SerialName("type")
    val mapType: MapType,

    @SerialName("scores")
    val scores: WorldCount = WorldCount()
)