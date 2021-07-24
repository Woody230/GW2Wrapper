package com.bselzer.library.gw2.model.common.wvw.objective.upgrade

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TierUpgrade(
    @SerialName("name")
    val name: String,

    @SerialName("description")
    val description: String = "",

    @SerialName("icon")
    val iconLink: String = ""
)