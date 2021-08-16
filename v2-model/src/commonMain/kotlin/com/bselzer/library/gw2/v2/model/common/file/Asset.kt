package com.bselzer.library.gw2.v2.model.common.file

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Asset(
    @SerialName("id")
    val id: String = "",

    @SerialName("icon")
    val iconLink: String = ""
)