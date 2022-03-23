package com.bselzer.gw2.v2.model.wvw.map

import com.bselzer.gw2.v2.model.value.WvwMapBonusType
import com.bselzer.gw2.v2.model.value.WvwObjectiveOwner
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwMapBonus(
    @SerialName("type")
    val type: WvwMapBonusType = WvwMapBonusType(),

    @SerialName("owner")
    val owner: WvwObjectiveOwner = WvwObjectiveOwner()
)