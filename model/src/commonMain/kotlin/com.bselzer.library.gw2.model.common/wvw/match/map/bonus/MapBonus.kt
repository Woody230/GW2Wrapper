package com.bselzer.library.gw2.model.common.wvw.match.map.bonus

import com.bselzer.library.gw2.model.common.wvw.match.map.objective.MapObjectiveOwner
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MapBonus(
    @SerialName("type")
    val type: MapBonusType,

    @SerialName("owner")
    val owner: MapObjectiveOwner
)