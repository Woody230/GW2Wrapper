package com.bselzer.library.gw2.v2.model.common.quaggan

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Quaggan(
    @SerialName("id")
    val id: String = "",

    @SerialName("url")
    val iconLink: String = ""
)