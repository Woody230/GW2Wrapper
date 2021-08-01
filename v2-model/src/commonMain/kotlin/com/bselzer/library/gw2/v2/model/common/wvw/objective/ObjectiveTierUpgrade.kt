package com.bselzer.library.gw2.v2.model.common.wvw.objective

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ObjectiveTierUpgrade(
    @SerialName("name")
    val name: String,

    @SerialName("description")
    val description: String = "",

    @SerialName("icon")
    val iconLink: String = ""
)