package com.bselzer.gw2.v2.model.wvw.match

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwWorldId(
    @SerialName("red")
    val red: Int = 0,

    @SerialName("blue")
    val blue: Int = 0,

    @SerialName("green")
    val green: Int = 0
)