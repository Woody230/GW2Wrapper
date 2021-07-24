package com.bselzer.library.gw2.model.common.wvw.objective

import com.bselzer.library.gw2.model.common.wvw.match.map.MapType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Objective(
    @SerialName("id")
    val id: String,

    @SerialName("name")
    val name: String = "",

    @SerialName("type")
    val type: ObjectiveType,

    @SerialName("sector_id")
    val mapSectorId: Int = 0,

    @SerialName("map_id")
    val mapId: Int = 0,

    @SerialName("map_type")
    val mapType: MapType,

    @SerialName("coord")
    val coordinates: List<Double> = emptyList(),

    @SerialName("label_coord")
    val labelCoordinates: List<Double> = emptyList(),

    @SerialName("marker")
    val iconLink: String = "",

    @SerialName("chatLink")
    val chatLink: String = "",

    @SerialName("upgrade_id")
    val upgradeId: Int = 0
)