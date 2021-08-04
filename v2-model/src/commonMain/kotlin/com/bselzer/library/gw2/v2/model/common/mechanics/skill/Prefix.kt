package com.bselzer.library.gw2.v2.model.common.mechanics.skill

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Prefix(
    @SerialName("text")
    val description: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("status")
    val effect: String = "",

    @SerialName("description")
    val effectDescription: String = ""
)