package com.bselzer.library.gw2.v2.model.common.mechanics.race

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Race(
    @SerialName("id")
    val id: String,

    @SerialName("name")
    val name: String = "",

    @SerialName("skills")
    val skillIds: List<Int> = emptyList()
)