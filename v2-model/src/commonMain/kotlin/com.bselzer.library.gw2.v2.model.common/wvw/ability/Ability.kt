package com.bselzer.library.gw2.v2.model.common.wvw.ability

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Ability(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    @SerialName("icon")
    val icon: String,

    @SerialName("ranks")
    val ranks: List<AbilityRank>
)