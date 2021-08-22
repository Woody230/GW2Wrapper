package com.bselzer.library.gw2.v2.model.common.wvw.ability

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwAbilityRank(
    @SerialName("cost")
    val cost: Int = 0,

    @SerialName("effect")
    val effect: String = ""
)