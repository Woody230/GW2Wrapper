package com.bselzer.library.gw2.model.common.race

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Race(
    @SerialName("id")
    val id: String,

    @SerialName("name")
    val name: RaceName,

    @SerialName("skills")
    val skillIds: List<Int> = emptyList()
)