package com.bselzer.gw2.v2.model.wvw.match

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwWorldIds(
    @SerialName("red")
    val red: List<Int> = emptyList(),

    @SerialName("blue")
    val blue: List<Int> = emptyList(),

    @SerialName("green")
    val green: List<Int> = emptyList()
)