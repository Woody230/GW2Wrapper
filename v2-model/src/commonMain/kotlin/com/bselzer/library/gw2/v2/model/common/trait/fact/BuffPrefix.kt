package com.bselzer.library.gw2.v2.model.common.trait.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BuffPrefix(
    @SerialName("text")
    val description: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("status")
    val status: String = "",

    @SerialName("description")
    val effectDescription: String = ""
)
