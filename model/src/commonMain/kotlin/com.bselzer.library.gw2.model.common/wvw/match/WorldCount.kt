package com.bselzer.library.gw2.model.common.wvw.match

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WorldCount(
    @SerialName("red")
    val red: Int = 0,

    @SerialName("blue")
    val blue: Int = 0,

    @SerialName("green")
    val green: Int = 0
)