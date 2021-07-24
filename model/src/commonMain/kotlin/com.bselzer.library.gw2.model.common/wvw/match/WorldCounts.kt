package com.bselzer.library.gw2.model.common.wvw.match

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WorldCounts(
    @SerialName("red")
    val red: List<Int> = emptyList(),

    @SerialName("blue")
    val blue: List<Int> = emptyList(),

    @SerialName("green")
    val green: List<Int> = emptyList()
)