package com.bselzer.gw2.v2.model.wvw.map

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwMapBonus(
    @SerialName("type")
    val type: com.bselzer.gw2.v2.model.wrapper.WvwMapBonusType = com.bselzer.gw2.v2.model.wrapper.WvwMapBonusType(),

    @SerialName("owner")
    val owner: com.bselzer.gw2.v2.model.wrapper.WvwObjectiveOwner = com.bselzer.gw2.v2.model.wrapper.WvwObjectiveOwner()
)